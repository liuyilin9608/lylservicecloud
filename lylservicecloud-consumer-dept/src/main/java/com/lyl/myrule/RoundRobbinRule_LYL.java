package com.lyl.myrule;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

//问题：依旧轮询策略，但是加上新需求，每个服务器被要求调用5次，以前是每台机器一次，现在是每台机器5次
public class RoundRobbinRule_LYL extends AbstractLoadBalancerRule {
	
	private int total = 0; //总共被调用的次数
	private int currentIndex = 0; //当前提供服务的机器号
	
	public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
            /*//随机算法
            int index = chooseRandomInt(serverCount);
            server = upList.get(index);*/
            
            //自定义需求，5次一换的轮询算法
            if(total < 5){
            	//获得当前服务的机器号
            	server = upList.get(currentIndex);
            	total++;
            }else{
            	//调用5次后，清0，换下一台机器
            	total = 0;
            	currentIndex++;
            	//所有服务器轮询完，归0
                if(currentIndex >= upList.size()){
                	currentIndex = 0;
                }
            }
            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub
		
	}
}
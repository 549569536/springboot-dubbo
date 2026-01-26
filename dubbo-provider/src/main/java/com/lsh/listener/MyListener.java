package com.lsh.listener;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 监控/myNode节点数据变化
 */
@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent>,Watcher {

    private static final String ZOOKEEPER_ADDRESS = "localhost:2181";
    private static final int SESSION_TIMEOUT = 3000;
    private ZooKeeper zooKeeper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            zooKeeper = new ZooKeeper(ZOOKEEPER_ADDRESS,SESSION_TIMEOUT,this);
            watchNode("/myNode");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (!"/myNode".equals(watchedEvent.getPath())) {
            return;
        }
        try {
            if (Event.EventType.NodeCreated.equals(watchedEvent.getType())) {
                System.out.println("节点被创建");
            } else if (Event.EventType.NodeDataChanged.equals(watchedEvent.getType())) {
                System.out.println("节点数据被修改");
                byte[] data = zooKeeper.getData(watchedEvent.getPath(), this, null);
                System.out.println(new String(data));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                zooKeeper.exists(watchedEvent.getPath(),true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void watchNode(String path) throws Exception {
        zooKeeper.exists(path,true);
    }
}

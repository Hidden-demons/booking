//package com.hui;
//
//import com.hui.netty.WSServer;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class NettyBoater implements ApplicationListener<ContextRefreshedEvent> {
//
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		if (event.getApplicationContext().getParent() == null) {
//			try {
//				WSServer.getInstance().start();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//}

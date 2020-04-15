package com.mmm.mas.util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.mmm.mas.test.TestXml2;

public class UdpGroup2 {

	private static final char[] HEXES = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f'
    };
	
	protected boolean running = false;// 服务运行状态
	private boolean socketOpen;
	private Map<String, String> xmlmap;
	
	private String host = "255.255.255.255";
	private int port = 7001;
	private DatagramSocket socket;
	private DatagramPacket packet;
	private InetAddress group;

	private void getUdp() {
		xmlmap = new HashMap<String, String>();
		this.startupServices();
		while (running) {
			try {
				packet = new DatagramPacket(new byte[100], 100);
				socket.receive(packet);
				byte[] b = packet.getData();
				byte[] data = new byte[50];
				for (int i = 0; i < data.length; i++) {
					data[i] = b[i];
				}
//				String msg = new String(b, 0, packet.getLength()).replace(" ", "");
//				System.out.println(msg);
//				System.out.println(Arrays.toString(data));
				String ddata = getBufHexStr(data);
				System.out.println(ddata);
				
//				TestXml2 t = new TestXml2();
//				String p = t.getProto("C:\\Users\\ZHANGJX\\Desktop\\radar\\dianji.xml", "udp", xmlmap, ddata);
//				System.out.println(p);
			} catch (Exception e) {
				stopService();
				e.printStackTrace();
			}
		}
		stopService();
	}
	
	// 将16进制的byte数组转换成字符串
	public String getBufHexStr(byte[] data) {
		StringBuilder hex = new StringBuilder(data.length * 2);
	    for (byte b : data) {
	    	hex.append(HEXES[(b >> 4) & 0x0F]);
            hex.append(HEXES[b & 0x0F]);
	    }
	    return hex.toString().toUpperCase(Locale.getDefault());
	}

	// 将16进制的字符串转成字符数组
	public byte[] getHexBytes(String str) {
		byte[] bytes = new byte[str.length() / 2];
		for (int i = 0; i < str.length() / 2; i++) {
			String subStr = str.substring(i * 2, i * 2 + 2);
			bytes[i] = (byte) Integer.parseInt(subStr, 16);
		}
		return bytes;
	}
	
	/**
	 * 初始化参数信息 启动线程状态接收服务
	 */
	private void startupServices() {
		try {
			group = InetAddress.getByName(host);
			this.socket = new DatagramSocket(port);
//			this.socket.joinGroup(group);			//加入连接
//			this.socket.setSoTimeout(2000);
			this.socketOpen = true;
			running = true;
		} catch (Exception e) {
			e.printStackTrace();
			running = false;
		}
		this.socketOpen = true;
		running = true;
		System.out.println("组播开始");
	}

	/**
	 * 关闭服务
	 */
	public void stopService() {
		this.running = false;
		if (this.socketOpen) {
			try {
				this.socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.socketOpen = false;
		}
		System.out.println("组播停止");
	}

	public static void main(String[] args) {
		UdpGroup2 u = new UdpGroup2();
		u.getUdp();
	}
}

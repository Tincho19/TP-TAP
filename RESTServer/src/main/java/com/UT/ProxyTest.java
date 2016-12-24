package com.UT;

public class ProxyTest {

	public static void main(String[] args) {

		Proxy p = new Proxy();
		try {
			p.crearPedido("Martin;Araoz 2287;4567-5555;milanesas");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

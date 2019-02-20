package com.example.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CodeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(123);
		String[] arr = {"2", "3", "4", "5", "6", "7", "8", "A","B","C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T"
				,"U","V","W","X","Y","Z","a","b","c","d","e","f","h","i","j","k","m","n","p","q","r","s","t","u","v","w","x","y","z"};
//		 1 0 9  l o g I O
		// 1.随机生成4位数的字符串
		String valiCode = "";
		Random r = new Random();
		for(int i = 0; i < 4; i ++) {
			int index = r.nextInt(arr.length);
			valiCode += arr[index];
		}
		valiCode = valiCode.toLowerCase();
		System.out.println("验证码:" + valiCode);
		
		HttpSession hs = req.getSession();
		hs.setAttribute("code", valiCode);
		
		// 2、获取画笔
		// -- 这三个参数代表，图片的宽，高，颜色的色调 (制定一张纸，而这张纸，在内存中)
		BufferedImage bi = new BufferedImage(240, 40, BufferedImage.TYPE_INT_RGB);
		// -- 获取画笔
		Graphics g = bi.getGraphics();
		// -- 绘制白色背景
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 240, 40);
		// -- 绘制文字
		g.setColor(Color.RED);
		for (int i = 0; i < valiCode.length(); i ++) {
			String code = valiCode.charAt(i) + "";
			g.drawString(code, 50*i + 50, 24);
		}
		
		
		// 3、生成图片
		ByteArrayOutputStream baops = new ByteArrayOutputStream();
		ImageIO.write(bi, "jpg", baops);
		ByteArrayInputStream baips = new ByteArrayInputStream(baops.toByteArray());
		
		// 4、将数据发出去
		OutputStream ops = resp.getOutputStream();
		int len = 0;
		byte[] bs = new byte[1024];
		while(true) {
			len = baips.read(bs);
			if(len == -1) {
				break;
			}
			ops.write(bs, 0, len);
		}
		ops.flush();
		
	}
}

package com.example.springboot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

public class NetworkFileWriterJciFS {
	public static void main(String[] args) throws Exception {
//		new Main().writeOutputOnly();
		new NetworkFileWriterJciFS().writeOutpuStreamAndPrintFile();
	}

	private void writeOutpuStreamAndPrintFile() throws MalformedURLException, SmbException, IOException {
		String smbUrl = "smb://dorival:2008@vm-win7/users/Public/";

		String url2 = "smb://dorival:2008@vm-win7/users/Public/agora" + new Date().getTime() + ".txt";
		try (SmbFileOutputStream sout = new SmbFileOutputStream(new SmbFile(url2))) {
			SmbFile file = new SmbFile(smbUrl);

			for (String i : file.list()) {
				System.out.println(i);
			}
			sout.write((new Date() + ": Teste de String com novo arquivo").getBytes());
			
			url2 = "smb://dorival:2008@vm-win7/users/Public/";
			file = new SmbFile(smbUrl);
			for (String i : file.list()) {
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void writeOutputOnly() throws MalformedURLException, SmbException, IOException {
		String url2 = "smb://dorival:2008@vm-win7/users/Public/agora"+new Date().getTime()+".txt";
		//url2 = path.toString();
		
		try(SmbFileOutputStream out = new SmbFileOutputStream(new SmbFile(url2 ))){
			out.write((new Date()+"Conteudo arquivo\n").getBytes());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

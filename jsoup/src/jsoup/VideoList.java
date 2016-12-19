package jsoup;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class VideoList {
	
	public void tvcast(String url) {
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			//File in = new File("C:\\htmlPage\\tvcast.html");
			//doc = Jsoup.parse(in, "UTF-8");
			
			// top 3
			Elements top3Area = doc.select("div.top_flick ul.rolling li");
			Iterator<Element> top3_it = top3Area.iterator();
			while (top3_it.hasNext()) {
				Element elm = top3_it.next();
				Elements title = elm.select("div.inner a.box div.info strong.tit span");
				Iterator<Element> it_title = title.iterator();
				while (it_title.hasNext()) {
					Element tit = it_title.next();
					System.out.println(tit.text());
				}
			}
						
			// top 4 ~
			Elements listArea = doc.select("div.cds_area div.cds div.cds_type");
			Iterator<Element> it = listArea.iterator();
			
			while (it.hasNext()) {
				Element elm = it.next();
				Elements title = elm.select("dl.cds_info dt.title");
				Iterator<Element> it_title = title.iterator();
				while (it_title.hasNext()) {
					Element tit = it_title.next();
					System.out.print(tit.text());
				}
				Elements rank = elm.select("span.num");
				Iterator<Element> it_rank = rank.iterator();
				while (it_rank.hasNext()) {
					Element ra = it_rank.next();
					//System.out.print(" rank = " + ra.text());
				}
				System.out.println();
			}
			
		} catch (IOException ie){
			ie.printStackTrace();
		}
	}
	
	public void youtube(String url){
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			//File in = new File("C:\\htmlPage\\youtube.html");
			//doc = Jsoup.parse(in, "UTF-8");
			
			Elements listArea = doc.select("div.expanded-shelf ul li");
			Iterator<Element> it = listArea.iterator();
			
			while (it.hasNext()) {
				Element elm = it.next();
				Elements title = elm.select("div div div div h3 a");
				Iterator<Element> it_title = title.iterator();
				while (it_title.hasNext()) {
					Element tit = it_title.next();
					System.out.println(tit.text());
				}
			}
		} catch (IOException ie){
			ie.printStackTrace();
		}
	}
	
	public void tvpot(String url){
		Document doc;
		try {
			//doc = Jsoup.connect(url).get();
			File in = new File("C:\\htmlPage\\tvpot.html");
			doc = Jsoup.parse(in, "UTF-8");
			
			Elements listArea = doc.select("#clipList li");
			Iterator<Element> it = listArea.iterator();
			
			while (it.hasNext()) {
				Element elm = it.next();
				Elements title = elm.select("dl dd.title a");
				Iterator<Element> it_title = title.iterator();
				while (it_title.hasNext()) {
					Element tit = it_title.next();
					System.out.println(tit.text());
				}
			}
		} catch (IOException ie){
			ie.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String tvcastUrl = "http://tvcast.naver.com/r/";
		String youtubeUrl = "https://www.youtube.com/feed/trending";
		String tvpotUrl = "http://tvpot.daum.net/best/Top.do?from=gnb";
		VideoList videoList= new VideoList();
		//videoList.tvcast(tvcastUrl);
		videoList.youtube(youtubeUrl);
		//videoList.tvpot(tvpotUrl);
	}
}

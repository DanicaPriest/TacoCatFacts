package mybatis.model.nyt.threads.nyt;

import mybatis.model.nyt.NYTDocs;
import mybatis.model.nyt.NYTRoot;
import mybatis.model.nyt.internal.NYTOverview;
import mybatis.services.NYTService;


public class NYTOverviewThread implements Runnable{

    NYTService nytService = new NYTService();

    Thread thrd;
    NYTRoot data;

    public NYTOverviewThread(NYTRoot data) {
        thrd = new Thread(this);
        this.data = data;
        thrd.start();
    }

    @Override
    public void run() {
/*
        for (NYTDocs result: data.getResponse().getDocs()
             ) {
            NYTOverview obj = new NYTOverview();

            obj.setDate(result.getPub_date());
            obj.setHeadline(result.getHeadline().getMain());
            obj.setSummary(result.getSnippet());
            try {
                obj.setImageurl(result.getMultimedia()[0].getUrl());
            }catch (Exception e){
                obj.setImageurl("n/a");

            }

            nytService.insertNYTSummary(obj);
        }
        System.out.println("*****persistance thread is complete");*/
    }
}

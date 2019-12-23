package com.example.myapplication;

import java.util.List;

public class HomeBean {

    /**
     * result : [{"collection":0,"id":40,"releaseTime":1539400915000,"share":0,"source":"盖世汽车资讯","summary":"盖世汽车讯 据外媒报道，戴姆勒与博世共同研发了一种自动驾驶系统，将于2019年下半年在加利福尼亚州开始对该系统进行测试","thumbnail":"https://inews.gtimg.com/newsapp_bt/0/5726426616/1000","title":"戴姆勒合作博世 2019年底在加州城市交通中测试完全自动驾驶汽车","whetherAdvertising":2,"whetherCollection":2,"whetherPay":2},{"collection":1,"id":39,"releaseTime":1539400673000,"share":0,"source":"看航空","summary":"据报道，自从莱特兄弟时代以来，航空业和创新就一直相伴而行。曾经在远程航班上，飞机由四个发动机驱动，驾驶舱时刻要有至少三名飞行员","thumbnail":"https://inews.gtimg.com/newsapp_ls/0/5725634179_294195/0","title":"无人驾驶航班离成为现实更近了一步","whetherAdvertising":2,"whetherCollection":2,"whetherPay":1},{"collection":0,"id":38,"releaseTime":1539397684000,"share":0,"source":"汽车AI科技","summary":"关于汽车前沿科技 你关心的都在这","thumbnail":"https://inews.gtimg.com/newsapp_bt/0/2572709743/1000","title":"汽车AI科技日报 | 长安汽车正开发L3级自动驾驶技术，预计2020年量产","whetherAdvertising":2,"whetherCollection":2,"whetherPay":2},{"collection":1,"id":37,"releaseTime":1539396988000,"share":0,"source":"汽车之友","summary":"1956年，约翰·麦卡锡在达特矛斯会议上，首次正式提出了\u201c人工智能\u201d的定义。如今，整整62年过去了，人工智能迎来了新的爆发。","thumbnail":"https://inews.gtimg.com/newsapp_ls/0/5747369805_196130/0","title":"AI改变驾驶，华为与奥迪在L4自动驾驶领域联合创新","whetherAdvertising":2,"whetherCollection":2,"whetherPay":2},{"collection":0,"id":36,"releaseTime":1539396537000,"share":0,"source":"汽车评中评","summary":"无论是我们之前探访的研究自动驾驶的科技公司、还是传统车企，仍至国内汽车研究院都是没有停止自动驾驶技术完善的步伐，从中也全景化的看到汽车朝智能化发展的趋势，技术上面的日臻完善只是时间问题。","thumbnail":"https://inews.gtimg.com/newsapp_ls/0/5748754883_196130/0","title":"无人驾驶汽车出了车祸怎么办？Uber、特斯拉接连出事，谁该为车祸埋单？","whetherAdvertising":2,"whetherCollection":2,"whetherPay":2}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * collection : 0
         * id : 40
         * releaseTime : 1539400915000
         * share : 0
         * source : 盖世汽车资讯
         * summary : 盖世汽车讯 据外媒报道，戴姆勒与博世共同研发了一种自动驾驶系统，将于2019年下半年在加利福尼亚州开始对该系统进行测试
         * thumbnail : https://inews.gtimg.com/newsapp_bt/0/5726426616/1000
         * title : 戴姆勒合作博世 2019年底在加州城市交通中测试完全自动驾驶汽车
         * whetherAdvertising : 2
         * whetherCollection : 2
         * whetherPay : 2
         */

        private int collection;
        private int id;
        private long releaseTime;
        private int share;
        private String source;
        private String summary;
        private String thumbnail;
        private String title;
        private int whetherAdvertising;
        private int whetherCollection;
        private int whetherPay;

        public int getCollection() {
            return collection;
        }

        public void setCollection(int collection) {
            this.collection = collection;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getWhetherAdvertising() {
            return whetherAdvertising;
        }

        public void setWhetherAdvertising(int whetherAdvertising) {
            this.whetherAdvertising = whetherAdvertising;
        }

        public int getWhetherCollection() {
            return whetherCollection;
        }

        public void setWhetherCollection(int whetherCollection) {
            this.whetherCollection = whetherCollection;
        }

        public int getWhetherPay() {
            return whetherPay;
        }

        public void setWhetherPay(int whetherPay) {
            this.whetherPay = whetherPay;
        }
    }
}

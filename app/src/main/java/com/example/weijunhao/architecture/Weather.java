package com.example.weijunhao.architecture;

import java.util.List;

/**
 * Created by WEI JUNHAO on 2017/5/12.
 */

public class Weather {

    /**
     * wendu : 18
     * ganmao : 鐩稿浜庝粖澶╁皢浼氬嚭鐜板ぇ骞呭害闄嶆俯锛屾槗鍙戠敓鎰熷啋锛屾敞鎰忓鍔犺。鏈嶏紝鍔犲己鑷垜闃叉姢閬垮厤鎰熷啋銆�
     * forecast : [{"fengxiang":"涓滃寳椋�","fengli":"3-4绾�","high":"楂樻俯 22鈩�","type":"涓洦","low":"浣庢俯 17鈩�","date":"12鏃ユ槦鏈熶簲"},{"fengxiang":"鍗楅","fengli":"寰绾�","high":"楂樻俯 30鈩�","type":"鏅�","low":"浣庢俯 19鈩�","date":"13鏃ユ槦鏈熷叚"},{"fengxiang":"涓滃寳椋�","fengli":"寰绾�","high":"楂樻俯 28鈩�","type":"澶氫簯","low":"浣庢俯 19鈩�","date":"14鏃ユ槦鏈熷ぉ"},{"fengxiang":"涓滈","fengli":"寰绾�","high":"楂樻俯 26鈩�","type":"澶氫簯","low":"浣庢俯 18鈩�","date":"15鏃ユ槦鏈熶竴"},{"fengxiang":"涓滃寳椋�","fengli":"寰绾�","high":"楂樻俯 26鈩�","type":"澶氫簯","low":"浣庢俯 17鈩�","date":"16鏃ユ槦鏈熶簩"}]
     * yesterday : {"fl":"寰","fx":"鍗楅","high":"楂樻俯 33鈩�","type":"澶氫簯","low":"浣庢俯 19鈩�","date":"11鏃ユ槦鏈熷洓"}
     * aqi : 65
     * city : 涓婃捣
     */

    private String wendu;
    private String ganmao;
    private YesterdayBean yesterday;
    private String aqi;
    private String city;
    private List<ForecastBean> forecast;

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public YesterdayBean getYesterday() {
        return yesterday;
    }

    public void setYesterday(YesterdayBean yesterday) {
        this.yesterday = yesterday;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<ForecastBean> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastBean> forecast) {
        this.forecast = forecast;
    }

    public static class YesterdayBean {
        /**
         * fl : 寰
         * fx : 鍗楅
         * high : 楂樻俯 33鈩�
         * type : 澶氫簯
         * low : 浣庢俯 19鈩�
         * date : 11鏃ユ槦鏈熷洓
         */

        private String fl;
        private String fx;
        private String high;
        private String type;
        private String low;
        private String date;

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getFx() {
            return fx;
        }

        public void setFx(String fx) {
            this.fx = fx;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    public static class ForecastBean {
        /**
         * fengxiang : 涓滃寳椋�
         * fengli : 3-4绾�
         * high : 楂樻俯 22鈩�
         * type : 涓洦
         * low : 浣庢俯 17鈩�
         * date : 12鏃ユ槦鏈熶簲
         */

        private String fengxiang;
        private String fengli;
        private String high;
        private String type;
        private String low;
        private String date;

        public String getFengxiang() {
            return fengxiang;
        }

        public void setFengxiang(String fengxiang) {
            this.fengxiang = fengxiang;
        }

        public String getFengli() {
            return fengli;
        }

        public void setFengli(String fengli) {
            this.fengli = fengli;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}

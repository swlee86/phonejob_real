package kr.or.phonejob.Dto;


public class ShopDto {

    private String phone_seq;
    private String phone_name;
    private String phone_model;
    private String phone_price;
    private String publicsubsidy;
    private String privatesubsidy;
    private String phone_img;
    private String phone_dtl;
    private String sellyn;

    public String getPhone_seq() {
        return phone_seq;
    }

    public void setPhone_seq(String phone_seq) {
        this.phone_seq = phone_seq;
    }

    public String getPhone_name() {
        return phone_name;
    }

    public void setPhone_name(String phone_name) {
        this.phone_name = phone_name;
    }

    public String getPhone_model() {
        return phone_model;
    }

    public void setPhone_model(String phone_model) {
        this.phone_model = phone_model;
    }

    public String getPhone_price() {
        return phone_price;
    }

    public void setPhone_price(String phone_price) {
        this.phone_price = phone_price;
    }

    public String getPublicsubsidy() {
        return publicsubsidy;
    }

    public void setPublicsubsidy(String publicsubsidy) {
        this.publicsubsidy = publicsubsidy;
    }

    public String getPrivatesubsidy() {
        return privatesubsidy;
    }

    public void setPrivatesubsidy(String privatesubsidy) {
        this.privatesubsidy = privatesubsidy;
    }

    public String getPhone_img() {
        return phone_img;
    }

    public void setPhone_img(String phone_img) {
        this.phone_img = phone_img;
    }

    public String getPhone_dtl() {
        return phone_dtl;
    }

    public void setPhone_dtl(String phone_dtl) {
        this.phone_dtl = phone_dtl;
    }

    public String getSellyn() {
        return sellyn;
    }

    public void setSellyn(String sellyn) {
        this.sellyn = sellyn;
    }

    @Override
    public String toString() {
        return "ShopDto{" +
                "phone_seq='" + phone_seq + '\'' +
                ", phone_name='" + phone_name + '\'' +
                ", phone_model='" + phone_model + '\'' +
                ", phone_price='" + phone_price + '\'' +
                ", publicsubsidy='" + publicsubsidy + '\'' +
                ", privatesubsidy='" + privatesubsidy + '\'' +
                ", phone_img='" + phone_img + '\'' +
                ", phone_dtl='" + phone_dtl + '\'' +
                ", sellyn='" + sellyn + '\'' +
                '}';
    }
}

package utils.core;

/**
 * Created with IntelliJ IDEA.
 * User: glebeda
 * Date: 06.07.16
 * Time: 11:24
 * To change this template use File | Settings | File Templates.
 */
public class Config {

    public String ticketURL;
    public String merchantURL;
    public String cafeURL;
    public String merchantLogin;
    public String merchantPassword;

    public String getTicketURL() {
        return ticketURL;
    }

    public void setTicketURL(String ticketURL) {
        this.ticketURL = ticketURL;
    }

    public String getMerchantURL() {
        return merchantURL;
    }

    public void setMerchantURL(String merchantURL) {
        this.merchantURL = merchantURL;
    }

    public String getMerchantLogin() {
        return merchantLogin;
    }

    public void setMerchantLogin(String merchantLogin) {
        this.merchantLogin = merchantLogin;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public String getCafeURL() {
        return cafeURL;
    }

    public void setCafeURL(String cafeURL) {
        this.cafeURL = cafeURL;
    }
}

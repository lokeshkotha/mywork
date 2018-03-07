/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vib.beans;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;
import com.mongo.testing.MasterDAO;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import com.mongo.location.TestingDAO;
import com.vib.utilities.AtomPaymentServices;
import com.vib.utilities.PayUMoney;
import com.vib.utilities.PaymentDetails;
import com.vib.utilities.Paypal;
import com.vib.utilities.Paytm;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
//import javax.inject.Named;

/**
 *
 * @author itdev8
 */
@ManagedBean(name = "UsersBean")
//@Named
//@SessionScoped
@SessionScoped
public class UsersBean {

    /**
     * Creates a new instance of UsersBean
     */
    public UsersBean() throws Exception {
//        ExcelUpload eu=new ExcelUpload();
////        eu.addCities();
////        eu.addExcelData();
////        eu.uploadFeed();
//        eu.test();
        MasterDAO mdao = new MasterDAO();
//        mdao.saveState();
        checkoutpage = false;
        totalproductprice = 0.0;
        testing();
//        saveState();
//        cookiesTesting();
//        atomPayment();
    }

    private Date dob;
    private String confirmpassword;
    private Double totalproductprice;
    private Map<String, String> payumap = new LinkedHashMap<String, String>();
    private Map<String, String> paytmmap = new TreeMap<String, String>();
    private Map<String, String> atommap = new LinkedHashMap<String, String>();
    private Map<String, String> atommap2 = new LinkedHashMap<String, String>();
   
    private String mobileno;
    private String paymentId;
    private String state;
    private String totalamount;
    private String status;
    private String failurereason;
    private Boolean validatemsg;
    private Boolean checkoutpage;
    private String city;
    private String ipaddress;
    private String country;
    private String currency;
    private String Atom2Request = "";

    public String getAtom2Request() {
        return Atom2Request;
    }

    public void setAtom2Request(String Atom2Request) {
        this.Atom2Request = Atom2Request;
    }

    public Map<String, String> getAtommap2() {
        return atommap2;
    }

    public void setAtommap2(Map<String, String> atommap2) {
        this.atommap2 = atommap2;
    }

    public Map<String, String> getAtommap() {
        return atommap;
    }

    public void setAtommap(Map<String, String> atommap) {
        this.atommap = atommap;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<String, String> getPaytmmap() {
        return paytmmap;
    }

    public void setPaytmmap(Map<String, String> paytmmap) {
        this.paytmmap = paytmmap;
    }

    public String getFailurereason() {
        return failurereason;
    }

    public void setFailurereason(String failurereason) {
        this.failurereason = failurereason;
    }

    public Map<String, String> getPayumap() {
        return payumap;
    }

    public void setPayumap(Map<String, String> payumap) {
        this.payumap = payumap;
    }

    public Boolean getCheckoutpage() {
        return checkoutpage;
    }

    public void setCheckoutpage(Boolean checkoutpage) {
        this.checkoutpage = checkoutpage;
    }

 

    public Boolean getValidatemsg() {
        return validatemsg;
    }

    public void setValidatemsg(Boolean validatemsg) {
        this.validatemsg = validatemsg;
    }


    public Double getTotalproductprice() {
        return totalproductprice;
    }

    public void setTotalproductprice(Double totalproductprice) {
        this.totalproductprice = totalproductprice;
    }

   

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

   
  

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

  

    //login validations and registrations
    public void validatelogin() throws IOException {
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        System.out.println("entered invalidate login");
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginCustomer") == null) {
            System.out.println("logging off");
            FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/login.xhtml");
        }
    }

    



    public String logout() throws IOException {
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/redirect.xhtml");
        return "redirect?faces-redirect=true";
    }






//    paypal
    public void payPal() throws PayPalRESTException, IOException {
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        try {
            String price = String.valueOf(totalproductprice);
            Paypal paypal = new Paypal();
            String url = paypal.payMent(price);
            if (url.equals("")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/forms/error.xhtml");
            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect(url);
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/forms/error.xhtml");
        }
    }

    public void paypalResponse() throws PayPalRESTException, IOException {
        Paypal paypal = new Paypal();
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, String> params = et.getRequestParameterMap();
        String pid = (String) params.get("paymentId");
        String token = (String) params.get("token");
        String payerid = (String) params.get("PayerID");
        Payment payment = paypal.lastResponse(pid, token, payerid);
        try {
            if (payment.getState().equals("approved")) {
                paymentId = payment.getId();
                state = payment.getState();
                status = payment.getPayer().getStatus();
                Transaction transaction = payment.getTransactions().get(0);
                totalamount = transaction.getAmount().getTotal();
                paypalSuccess(paymentId, state, status, totalamount);
            } else {
                failurereason = payment.getFailureReason();
                FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/payment/failure.xhtml");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/payment/failure.xhtml");
        }
    }

    public void paypalSuccess(String paymentid, String state1, String status1, String totalamount) throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
//        PaymentCompletedRequest pcr = new PaymentCompletedRequest();
//        double amt = Double.parseDouble(totalamount);
//        pcr.setAmount(amt);
//        pcr.setPaymentid(paymentid);
//        String salesorderid = (String) facesContext.getExternalContext().getSessionMap().get("salesorderid");
//        pcr.setSalesorderid(salesorderid);
//        Channels customer = (Channels) facesContext.getExternalContext().getSessionMap().get("loginCustomer");
//        pcr.setChannelid(customer);
//        soplistconfirm.clear();
//        soplistconfirm = adao.getSopByCustomer(customer.getId());
//        adao.setPaymentInformation(pcr);
//        paymentId = paymentid;
//        state = state1;
//        status = status1;
//        invoice = adao.getInvoicesByPaymentId(paymentId);
//        salesOrderProductsByCustomer();
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/payment/confirmation.xhtml");
    }
    URLConnection con;
    URL url = null;
    String vVenderURL;
    String xmlURL = "";
    String xmlttype = "";
    String xmltempTxnId = "";
    String xmltoken = "";
    String xmltxnStage = "";

    public void atomPayment() throws UnsupportedEncodingException, IOException, ParserConfigurationException, SAXException {
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        try {
            PaymentDetails details = new PaymentDetails();
            details.setAmount("100");
            details.setClientcode("123456789abcd");
            details.setCustacc("888888888888");
            details.setTxnid("TX1234567890");
            details.setEmail("testing@gmail.com");
            details.setFirstname("testing");
            details.setPhone("9123412345");
            AtomPaymentServices aps = new AtomPaymentServices();
            atommap = aps.getURLParams(details);
            vVenderURL = atommap.get("url") + "?login=" + atommap.get("login") + "&pass=" + atommap.get("pass") + "&ttype=" + atommap.get("ttype")
                    + "&prodid=" + atommap.get("prodid") + "&amt=" + atommap.get("amt") + "&txncurr=" + atommap.get("txncurr") + "&txnscamt="
                    + atommap.get("txnscamt") + "&clientcode=" + atommap.get("clientcode") + "&txnid=" + atommap.get("txnid") + "&date="
                    + atommap.get("date") + "&custacc=" + atommap.get("custacc") + "&ru=" + atommap.get("ru") + "&udf1=" + atommap.get("udf1") + "&udf2=" + atommap.get("udf2") + "&udf3=" + atommap.get("udf3");
            vVenderURL = vVenderURL.replace(" ", "%20");
            System.out.println(vVenderURL);
            url = new URL(vVenderURL.toString());
            con = url.openConnection(Proxy.NO_PROXY);
            String CntType = con.getContentType();
            System.out.println("Cnt Type " + CntType + " Length : " + con.getContentLength());
            if (con.getContentLength() != 0) {
                System.out.println("Getting Content");
                BufferedReader inBuf = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                String vXMLStr = "";
                while ((inputLine = inBuf.readLine()) != null) {
                    System.out.println(inputLine);
                    vXMLStr = vXMLStr + inputLine;
                }
                inBuf.close();
                System.out.println("Got Content");
                System.out.println(vXMLStr);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                InputSource isBuf = new InputSource();
                isBuf.setCharacterStream(new StringReader(vXMLStr));
                Document doc = dBuilder.parse(isBuf);
                doc.getDocumentElement().normalize();

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                NodeList nList = doc.getElementsByTagName("RESPONSE");

                for (int tempN = 0; tempN < nList.getLength(); tempN++) {
                    Node nNode = nList.item(tempN);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        System.out.println("URL : " + eElement.getElementsByTagName("url").item(0).getChildNodes().item(0).getNodeValue());
                        xmlURL = eElement.getElementsByTagName("url").item(0).getChildNodes().item(0).getNodeValue();
                        atommap2.put("xmlURL", xmlURL);
                        NodeList aList = eElement.getElementsByTagName("param");
                        String vParamName;
                        for (int atrCnt = 0; atrCnt < aList.getLength(); atrCnt++) {
                            vParamName = aList.item(atrCnt).getAttributes().getNamedItem("name").getNodeValue();
//                            System.out.println("<br>paramName : : " + vParamName);

                            if (vParamName.equals("ttype")) {
                                xmlttype = aList.item(atrCnt).getChildNodes().item(0).getNodeValue();
                                atommap2.put("xmlttype", xmlttype);
                            } else if (vParamName.equals("tempTxnId")) {
                                xmltempTxnId = aList.item(atrCnt).getChildNodes().item(0).getNodeValue();
                                atommap2.put("xmltempTxnId", xmltempTxnId);
                            } else if (vParamName.equals("token")) {
                                xmltoken = aList.item(atrCnt).getChildNodes().item(0).getNodeValue();
                                atommap2.put("xmltoken", xmltoken);
                            } else if (vParamName.equals("txnStage")) {
                                xmltxnStage = aList.item(atrCnt).getChildNodes().item(0).getNodeValue();
                                atommap2.put("xmltxnStage", xmltxnStage);
                            }
                        }
//                    out.println("<br><b>URL               : </b>" + xmlURL);
//                    out.println("<br><b>param : ttype     : </b>" + xmlttype);
//                    out.println("<br><b>param : tempTxnId : </b>" + xmltempTxnId);
//                    out.println("<br><b>param : token     : </b>" + xmltoken);
//                    out.println("<br><b>param : txnStage  : </b>" + xmltxnStage);
                    }
                }
                if (atommap2.isEmpty()) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/forms/error.xhtml");
                } else {
                    Atom2Request = xmlURL + "?ttype=" + xmlttype + "&tempTxnId=" + xmltempTxnId + "&token=" + xmltoken + "&txnStage=" + xmltxnStage;
                    Atom2Request = Atom2Request.replace(" ", "%20");
                    FacesContext.getCurrentInstance().getExternalContext().redirect(Atom2Request);
                }
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/forms/error.xhtml");
        }
    }

    public void atomRedirect() throws IOException {
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, String> params = et.getRequestParameterMap();
//        String redirecturl = params.get("url");
//        FacesContext.getCurrentInstance().getExternalContext().redirect(redirecturl);
    }
//    pay u money

    public void payumoneyPayment() throws IOException {
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        PaymentDetails details = new PaymentDetails();
        details.setAmount("1");
        details.setEmail("testing@gmail.com");
        details.setFirstname("testing");
        details.setPhone("9123412345");
        details.setProductinfo("music");
        PayUMoney payu = new PayUMoney();
        payumap.clear();
        payumap = payu.hashCalMethod(details);
        if (payumap.isEmpty()) {
            FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/forms/error.xhtml");
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/payment/payuredirect.xhtml");
        }
    }

    public void payuSuccess() {
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, String> params = et.getRequestParameterMap();
        String mihpayid = params.get("mihpayid");
    }

    public void payuFailure() {
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, String> params = et.getRequestParameterMap();
        String mihpayid = params.get("mihpayid");
    }

//    paytm
    public void paytmpayment() throws Exception {
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        Paytm paytm = new Paytm();
        paytmmap.clear();
        paytmmap = paytm.initiatePayment("9876543210", "test@gmail.com", "1.0");
        if (paytmmap.isEmpty()) {
            FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/forms/error.xhtml");
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect(et.getRequestContextPath() + "/faces/payment/paytmredirect.xhtml");
        }
    }

    public void paytmSuccess() {
        ExternalContext et = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, String> params = et.getRequestParameterMap();
//        params in case of success
        String MID = params.get("MID");
        String ORDERID = params.get("ORDERID");
        String TXNAMOUNT = params.get("TXNAMOUNT");
        String CURRENCY = params.get("CURRENCY");//INR
        String TXNID = params.get("TXNID");//32172214
        String BANKTXNID = params.get("BANKTXNID");//447789
        String STATUS = params.get("STATUS");//TXN_SUCCESS
        String RESPCODE = params.get("RESPCODE");//01
        String RESPMSG = params.get("RESPMSG");//Txn+Successful.
        String TXNDATE = params.get("TXNDATE");//2016-12-30+15:12:18.0
        String GATEWAYNAME = params.get("GATEWAYNAME");//WALLET
        String BANKNAME = params.get("BANKNAME");//which returns which bank card is used
        String PAYMENTMODE = params.get("PAYMENTMODE");//PPI
        String CHECKSUMHASH = params.get("CHECKSUMHASH");
        // if the payment is made through cc or dc the response would be Payment Mode, Auth Code,RRN,	 
//Bank Txn ID, Cust ID,CC/DC Last 4 digits,Bin Number,Issuing Ban,Promo Code,Promo Response,	 
//Pos ID
//        params in case of failure
        String RESPCODEFAILURE = params.get("RESPCODE");//14112
        String RESPMSGFAILURE = params.get("RESPMSG");//message containing failure reason
        String STATUSFAILURE = params.get("STATUS");//TXN_FAILURE
        String MIDFAILURE = params.get("MID");
        String TXNAMOUNTFAILURE = params.get("TXNAMOUNT");
        String ORDERIDFAILURE = params.get("ORDERID");
        String TXNIDFAILURE = params.get("TXNID");//32172286
        String CHECKSUMHASHFAILURE = params.get("CHECKSUMHASH");
    }

    public void clear() {
        mobileno = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mobileno");
//        Channels loginCustomer = (Channels) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginCustomer");
        UsersBean ub = ((UsersBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsersBean"));
        String sa = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("salesorderid");

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginCustomer", loginCustomer);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mobileno", mobileno);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("UsersBean", ub);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("salesorderid", sa);
    }

//page redirection for welcome page
    public void toWelcome() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        fc.getExternalContext().redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
    }

//    all page navigations
    public void toHome() throws IOException {
        checkoutpage = false;
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
    }

    public String toDetails() {
        return "details";
    }

    public String toIndex() {
        clear();
        return "indx";
    }

    public String toInnerIndex() {
        clear();
        return "innerindex";
    }

    public String toLoadFromBank() {
        clear();
        return "lfb";
    }

    public String toRedeemVoucher() {
        clear();
        return "rv";
    }

    public String toTvSubscription() {
        clear();
        return "tvs";
    }

    public String toElectricity() {
        clear();
        return "elc";
    }

    public String toWater() {
        clear();
        return "wat";
    }

    public String toEducation() {
        clear();
        return "edu";
    }

    public String toLoan() {
        clear();
        return "loan";
    }

    public String toAirtime() {
        clear();
        return "at";
    }

    public String toInternetBundles() {
        clear();
        return "ibs";
    }

    public String toVibStores() {
        clear();
        return "vbs";
    }

    public String toOnlineShopping() {
        clear();
        return "onshp";
    }

    public String toSendMoney() {
        clear();
        return "sm";
    }

    public String toRegister() {
        clear();
        return "register";
    }

    public String toMyInvoices() {
        clear();
        return "invoices";
    }

    public String toMyWishlist() {
//        clear();
        return "wishlist";
    }

    public String toViewMusic() {
//        clear();
        return "vmusic";
    }

    public String toViewVideos() {
//        clear();
        return "vvideos";
    }

    public String toViewGames() {
//        clear();
        return "vgames";
    }

    public String toViewBooks() {
//        clear();
        return "vbooks";
    }

    public String toConfirmpwd() {
        clear();
        return "confirmpwd";
    }

    public String tomusicdetails() {
        return "mdetails";
    }

    public String toVideodetails() {
        return "vdetails";
    }

    public String toBookdetails() {
        return "bdetails";
    }

    public String toGamedetails() {
        return "gdetails";
    }

    public String toCheckout() {
        clear();
        return "checkout";
    }

    public String toMyProducts() {
        clear();
        return "myproducts";
    }

    void testing() throws UnknownHostException, IOException, GeoIp2Exception {
        try {
//        to get local host address
//        InetAddress ip;
//        String hostname;
//        ip = InetAddress.getLocalHost();
//        InetAddress name = InetAddress.getByName(ip.getHostName());
//        InetAddress skgvbd = InetAddress.getLoopbackAddress();
//        hostname = ip.getHostName();
//        to get country using locale
//        Locale locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
//        String lovcale = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
//        String rsd = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale().getCountry();
//        String sedfrg = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale().getDisplayCountry();
//        String thb = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale().getISO3Country();
//        Iterator<Locale> locale1 = FacesContext.getCurrentInstance().getExternalContext().getRequestLocales();
//        to get request ipaddress
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String ipAddress = request.getHeader("X-FORWARDED-FOR");// for proxy
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }
            ipaddress = ipAddress;
//        System.out.println("ipAddress:" + ipAddress);
//        String dhygc = request.getLocalName();
//        Cookie[] skdn = request.getCookies();
//        Locale ed = request.getLocale();
//country
            File file = new File("/home/itdev8/Desktop/geolite apis/GeoLite2-Country.mmdb");
            DatabaseReader reader = new DatabaseReader.Builder(file).build();
            InetAddress ipAddress1 = InetAddress.getByName("91.197.232.11");
//            InetAddress ipAddress1 = InetAddress.getByName("137.74.41.9");
//            InetAddress ipAddress1 = InetAddress.getByName("108.61.229.191");
//            InetAddress ipAddress1 = InetAddress.getByName("188.166.210.186");
            CountryResponse countryResponse = reader.country(ipAddress1);
            Country c = countryResponse.getCountry();
            System.out.println(c.getIsoCode());
            System.out.println(c.getName());
            country = c.getName();

            Map<Currency, Locale> map = getCurrencyLocaleMap();
            Locale locale = new Locale("EN", c.getIsoCode());
            Currency currency1 = Currency.getInstance(locale);
            currency = currency1.getSymbol();
//        city GeoLite2-Country
//        File file1 = new File("C:\\Users\\itdev4\\Downloads\\GeoLite2-City.mmdb");
//        DatabaseReader cityreader = new DatabaseReader.Builder(file1).build();
//        InetAddress ipAddress2 = InetAddress.getByName(ipaddress);
//        CityResponse response = cityreader.city(ipAddress2);
//        Country countryl = response.getCountry();
//        country=countryl.getName();
//        System.out.println(countryl.getIsoCode());            
//        System.out.println(countryl.getName());               
//        System.out.println(countryl.getNames().get("zh-CN")); 
//
//        Subdivision subdivision = response.getMostSpecificSubdivision();
//        System.out.println(subdivision.getName());   
//        System.out.println(subdivision.getIsoCode());
//
//        City cityl = response.getCity();
//        city=cityl.getName();
//        System.out.println(cityl.getName()); 
//
//        Postal postal = response.getPostal();
//        System.out.println(postal.getCode()); 
//
//        Location location = response.getLocation();
//        System.out.println(location.getLatitude());  
//        System.out.println(location.getLongitude()); 

//         ServerLocation serverLocation=new ServerLocation();
//        LookupService lookup = new LookupService(file,LookupService.GEOIP_MEMORY_CACHE);
//	Location locationServices = lookup.getLocation(ipAddress);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static Map<Currency, Locale> getCurrencyLocaleMap() {
        Map<Currency, Locale> map = new HashMap();
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance(locale);
                map.put(currency, locale);
            } catch (Exception e) {
                // skip strange locale 
            }
        }
        return map;
    }

    public void saveState() {
        TestingDAO tdao = new TestingDAO();
//        State s = new State();
//        s.setStatename("Telangana");
//        String stateid=tdao.saveState(s);
//        
//        com.test.City c=new com.test.City();
//        c.setCityname("Hyderabad");
//        c.setStateid(stateid);
//        String cityid=tdao.saveCity(c);
        tdao.getCityById();
    }

    public void cookiesTesting() throws UnsupportedEncodingException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        UsersBean ub = ((UsersBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsersBean"));
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("maxAge", 31536000);
        properties.put("path", "/");
        ec.addResponseCookie("usersbean", URLEncoder.encode("ub", "UTF-8"), properties);
    }

}

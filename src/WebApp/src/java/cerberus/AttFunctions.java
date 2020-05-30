package cerberus;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import org.threeten.extra.YearWeek;

public class AttFunctions {

    public static void dbLog(String comment) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://172.21.170.14:3306/cerberus?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "cerberus", "abc@123");
            PreparedStatement ps = con.prepareStatement("insert into log values(null,?,?,?)");
           // int dateID = getDateID(getCurrDate());
            //int timeID = getTimeID(getCurrTime());
            //ps.setInt(1, dateID);
            //ps.setInt(2, timeID);
            ps.setString(3, comment);
            ps.executeUpdate();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
           
        }

    }

    public static String currUserName(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        try {
            return session.getAttribute("name").toString();
        } catch (Exception e) {
            return "False";
        }
    }

    public static String nameProcessor(String str) {
        char ch[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && ch[i] != ' ' || ch[i] != ' ' && ch[i - 1] == ' ') {
                if (ch[i] >= 'a' && ch[i] <= 'z') {
                    ch[i] = (char) (ch[i] - 'a' + 'A');
                }
            } else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char) (ch[i] + 'a' - 'A');
            }
        }
        String st = new String(ch);
        return st;
    }

    public static Object[] appendValue(Object[] obj, Object newObj) {

        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
        temp.add(newObj);
        return temp.toArray();

    }

    public static String hashIt(String raw) throws NoSuchAlgorithmException {
        raw = raw + "msubca";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        BigInteger number = new BigInteger(1, md.digest(raw.getBytes(StandardCharsets.UTF_8)));
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    public static String trimSQLInjection(String str) {
        String temp = str;
        temp = temp.replaceAll("\\s+", "");
        temp = temp.replaceAll("[A-Za-z0-9]+", "");
        temp = temp.replaceAll("\"", "'");
        return (temp);
    }

    public static String generateOTP() throws NoSuchAlgorithmException {
        String otpchars = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) {
            int index = (int) (rnd.nextFloat() * otpchars.length());
            salt.append(otpchars.charAt(index));
        }
        return salt.toString();
    }

    public static String generatePassword() throws NoSuchAlgorithmException {
        String otpchars = "ABCDEFGHJKLMNPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) {
            int index = (int) (rnd.nextFloat() * otpchars.length());
            salt.append(otpchars.charAt(index));
        }
        return salt.toString();
    }

    public static int getAccess(HttpServletRequest request) {
        int access;
        HttpSession session = request.getSession(false);
        try {
            access = (int) session.getAttribute("access");
        } catch (Exception e) {
            HttpSession sess = request.getSession(true);
            java.util.Date date = new java.util.Date();
            SimpleDateFormat ft = new SimpleDateFormat("w");
            int week = Integer.parseInt(ft.format(date));
            sess.setAttribute("week", week);
            sess.setAttribute("access", 2);
            access = 2;
        }
        return access;
    }

    public static void createSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("access", 2);
    }

    public static String getCurrWeekYear() {
        ZoneId z = ZoneId.of("Asia/Kolkata");
        YearWeek currentWeek = YearWeek.now(z);
        String result[] = (currentWeek + "").split("-W");
        return result[0] + "," + result[1];
    }

    public static String getPrevWeekYear(int week, int year) {
        ZoneId z = ZoneId.of("Asia/Kolkata");
        YearWeek currentWeek = YearWeek.of(year, week);
        currentWeek = currentWeek.minusWeeks(1);
        String result[] = (currentWeek + "").split("-W");
        return result[0] + "," + result[1];
    }

    public static String getNextWeekYear(int week, int year) {
        ZoneId z = ZoneId.of("Asia/Kolkata");
        YearWeek currentWeek = YearWeek.of(year, week);
        currentWeek = currentWeek.plusWeeks(1);
        String result[] = (currentWeek + "").split("-W");
        return result[0] + "," + result[1];
    }
    
    public static String getCurrDate() {
        Date date = new Date();
        return (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate();
    }

    public static int getCurrYear() {
        Date date = new Date();
        return (date.getYear() + 1900);
    }

    public static String getCurrTime() {
        Date date = new Date();
        return String.format("%02d", date.getHours()) + ":" + String.format("%02d", date.getMinutes()) + ":" + String.format("%02d", date.getSeconds());
    }
}

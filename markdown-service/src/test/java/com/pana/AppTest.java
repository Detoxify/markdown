package com.pana;

import junit.framework.TestCase;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public static void main(String[]  args){

        String s = "<input name=\"tbAcfvList[2].zboptValList[0].zboptVal\" id=\"8ae8d2885e9f4473015efb885cf50593\" class=\"checkRadio\" value=\"1\" type=\"hidden\" selected=\"selected\">" +
                "<input name=\"tbAcfvList[2].zboptValList[0].id\" value=\"8ae8d288606c28db01607d12c3221c0f\" type=\"hidden\">" +
                "<input name=\"tbAcfvList[2].zboptValList[0].acfvId\" value=\"8ae8d288606c28db01607d12c31f1c09\" type=\"hidden\">" +
                "<input name=\"tbAcfvList[2].zboptValList[0].zboptName\" value=\"opt_愿者组织章程\" type=\"hidden\">" +
                "<input name=\"tbAcfvList[2].zboptValList[0].zboptId\" value=\"8ae8d2885e9f4473015efb885cf50593\" type=\"hidden\">";
        int i = s.indexOf("tbAcfvList[");
        int j = s.indexOf(".zboptValList");
        String numStr = s.substring(i,j);
        System.out.println(numStr);

    }



    /**
     * 判断str1中包含str2的个数
     * @param str1
     * @param str2
     * @return counter
     */
    public static int countStr(String str1, String str2) {
        Integer counter = 0;
        if (str1.indexOf(str2) == -1) {
            return 0;
        } else if (str1.indexOf(str2) != -1) {
            counter++;
            countStr(str1.substring(str1.indexOf(str2) +
                    str2.length()), str2);
            return counter;
        }
        return 0;
    }

}

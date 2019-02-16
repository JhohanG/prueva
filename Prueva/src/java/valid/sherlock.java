/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
/**
 *
 * @author Ricardo
 */
@WebService(serviceName = "sherlock")
public class sherlock {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "Valid")
    public String hello(@WebParam(name = "palabra") String txt) {
        int mayor=0, menor=10000, t=0, u=0;
        int abc[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        //java.lang.String s=txt;
        java.lang.String abecedario="abcdefghijklmnopqrstuvwxyz";
        char[] ABC = abecedario.toCharArray();
        char[] s=txt.toCharArray();
        for (int i = 0; i < s.length; i++) {
            for (int j=0; j<26; j++){
                if (s[i] == ABC[j]){
                    abc[j]=abc[j]+1;
                }
            }
        }
        
        for (int i=0; i<26; i++){
            if (abc[i]> mayor){
                mayor=abc[i];
            }
            if (abc[i]< menor && abc[i]!=0){
                menor=abc[i];
            }
        }
        
        for (int i=0; i<26; i++){
            if (abc[i]==mayor ){
                t=t+1;
            }
            if (abc[i]<mayor && abc[i]!=0 ){
                u=u+1;
            }
        }
        
        if (mayor-menor==0){
            return "YES";
        }else if (mayor-menor==1 && t==0) {
            return "YES";
        }else if (mayor-menor==1 && t==1) {
            return "YES";
        }else if (mayor-menor==1 && u==0) {
            return "YES";
        }else if (mayor-menor==1 && u==1) {
            return "YES";
        }else if (menor==1 && u==1) {
            return "YES";
        }else{
            return "NO";
        }
        //return "OK";//"El caracter " + i + " es " + s[i];
    }





}

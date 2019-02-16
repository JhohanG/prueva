/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divi;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ricardo
 */
@WebService(serviceName = "Nodivisible")
public class Nodivisible {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "divisible")
    public Integer divisible(@WebParam(name = "nk") String nk, @WebParam(name = "Items") String Items) {
        //TODO write your implementation code here:
        String[] parts = nk.split(" ");
        String N=parts[0];
        String K=parts[1];
        int n = Integer.parseInt (N);
        int k = Integer.parseInt (K);
        int[] S = new int[n];
        String[] partsS = Items.split(" ");
        for (int i = 0; i < partsS.length; i++) {
            S[i]=Integer.parseInt (partsS[i]);
        }
        
        int[] b= new int[k];;
        for(int i=0;i<k;i++) {
            b[i]=0;
        }    
        for(int i=0;i<n;i++) {
            b[S[i]%k]+=1;
        }
        int c=0;
        c=Math.min(b[0],1);
        for(int i=1;i<k/2+1;i++) {
            if(i!=k-i) {
                c+=Math.max(b[i],b[k-i]);
                
            }
        }
        if(k%2==0) {
            c++;
        }
        
        return c;
    }
}

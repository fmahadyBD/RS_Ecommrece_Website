package com.rs.rs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.rs.dao.MessageRepository;
import com.rs.rs.models.Messages;

@Service
public class MessageService {
    @Autowired
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public static int evenOdd(int a, int b, int c) {

        int sum = a + b + c;
        if (sum % 2 == 0) {
            return 0;
        }
        return 1;
    }

    public Messages create(Messages messages) {
          /*
         * In here i will use hamming code to sent the messaga
         * 1. 2^r<=r+m+1
         * r=redundant data; m= data bit
         * 2.we need Parity bit to finding 1 bits of data errors. Even parity(even 1=>
         * 0,odd 1=>1), Odd parity(even 1=>1 ,odd 1=>0)
         * 
         * 
         * 
         * 
         */
        // int[] t = { 0, 1, 1, 0 };

        String s = messages.getMsg();
       
        int[] t = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            t[i] = s.charAt(i) - '0'; 
        }
      

        int m1 = 3, m2 = 5, m3 = 6, m4 = 7;
        int pi1 = 1, pi2 = 2, pi3 = 4;
        int[] m = new int[7];

        // add the input 4 bit in final array
        m[m1 - 1] = t[0];
        m[m2 - 1] = t[1];
        m[m3 - 1] = t[2];
        m[m4 - 1] = t[3];

        m[pi1 - 1] = evenOdd(t[0], t[1], t[3]);//  p1=m1m2m4
        m[pi2 - 1] = evenOdd(t[0], t[2], t[3]);// p2=m1m3m4;
        m[pi3 - 1] = evenOdd(t[1], t[2], t[3]);//p3=m2m3m4;

        //

        int a=0;
        for(int i=0;i<m.length;i++){
            a=a*10;
            a=a+m[i];
        }
       
        String str = String.valueOf(a);
        messages.setMsg(str);

        return repository.save(messages);
    }
}

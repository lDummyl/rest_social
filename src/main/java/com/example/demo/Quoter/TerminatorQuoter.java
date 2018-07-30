package com.example.demo.Quoter;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)

public class TerminatorQuoter implements Quoter {
    private String message;

    @InjectRandomInt(min = 2, max=7)
    private int repeat;

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }

    @PostConstruct
    public void intit(){
        System.out.println(repeat);
        System.out.println("Phase 2");
    }
    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

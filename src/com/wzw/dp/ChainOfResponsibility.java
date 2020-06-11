package com.wzw.dp;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        CommonManager commonManager =new CommonManager("经理");
        Majordomo majordomo = new Majordomo("总监");
        GeneralManager generalManager = new GeneralManager("总经理");

        commonManager.setSuperior(majordomo);
        majordomo.setSuperior(generalManager);

        Request request = new Request("请假", "请几天假", 1);
        Request request1 = new Request("请假", "请几天假", 5);
        Request request2 = new Request("请假", "请几天假", 10);
        Request request3 = new Request("加薪", "申请加息500", 500);
        Request request4 = new Request("加薪", "申请加息1000", 1000);

        commonManager.requestHandle(request);
        commonManager.requestHandle(request1);
        commonManager.requestHandle(request2);
        commonManager.requestHandle(request3);
        commonManager.requestHandle(request4);
    }
}

abstract class Manager {
    private String name;
    private Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    public Manager getSuperior() {
        return superior;
    }
    public abstract void requestHandle(Request request);
}

class CommonManager extends Manager {
    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestHandle(Request request) {
        if (request.getRequestType().equals("请假") && request.getRequestNum() <= 2) {
            System.out.printf("%s: %s 数量%d 被批准\n", getName(), request.getRequestContent(), request.getRequestNum());
        } else {
            if (getSuperior() != null) {
                getSuperior().requestHandle(request);
            }
        }
    }
}

class Majordomo extends Manager {
    public Majordomo(String name) {
        super(name);
    }

    @Override
    public void requestHandle(Request request) {
        if (request.getRequestType().equals("请假") && request.getRequestNum() <= 5) {
            System.out.printf("%s: %s 数量%d 被批准\n", getName(), request.getRequestContent(), request.getRequestNum());
        } else {
            if (getSuperior() != null) {
                getSuperior().requestHandle(request);
            }
        }
    }
}

class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestHandle(Request request) {
        if (request.getRequestType().equals("请假")) {
            System.out.printf("%s: %s 数量%d 被批准\n", getName(), request.getRequestContent(), request.getRequestNum());
        } else if (request.getRequestType().equals("加薪") && request.getRequestNum() <= 500) {
            System.out.printf("%s: %s 数量%d 被批准\n", getName(), request.getRequestContent(), request.getRequestNum());
        } else if (request.getRequestType().equals("加薪") && request.getRequestNum() > 500) {
            System.out.printf("%s: %s 数量%d 再说吧\n", getName(), request.getRequestContent(), request.getRequestNum());
        }
    }
}

class Request{
    private String requestType;
    private String requestContent;
    private int requestNum;

    public Request(String requestType, String requestContent, int requestNum) {
        this.requestType = requestType;
        this.requestContent = requestContent;
        this.requestNum = requestNum;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestType='" + requestType + '\'' +
                ", requestContent='" + requestContent + '\'' +
                ", requestNum=" + requestNum +
                '}';
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public int getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(int requestNum) {
        this.requestNum = requestNum;
    }
}
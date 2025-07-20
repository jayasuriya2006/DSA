package dsa.linkedlist.test;

import dsa.linkedlist.main.Browser;
import dsa.linkedlist.main.BrowserNode;

public class BrowserTest {

    public static void main(String[] args) {
        Browser browser = new Browser("test1.com");
        System.out.println(browser.currentTab.url);

        BrowserNode curTab = browser.visit("test3.com");
        System.out.println(curTab.url);

        curTab = browser.visit("test4.com");
        System.out.println(curTab.url);

        curTab = browser.visit("test5.com");
        System.out.println(curTab.url);

        curTab = browser.visit("test6.com");
        System.out.println(curTab.url);

        curTab = browser.back(2);
        System.out.println(curTab.url);

        curTab = browser.visit("test10.com");
        System.out.println(curTab.url);

        curTab = browser.back(3);
        System.out.println(curTab.url);

        curTab = browser.forward(3);
        System.out.println(curTab.url);

        curTab = browser.forward(4);
        System.out.println(curTab.url);

    }
}

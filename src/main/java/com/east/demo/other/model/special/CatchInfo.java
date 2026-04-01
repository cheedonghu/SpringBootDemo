package com.east.demo.other.model.special;

/**
 * try catch中父子类问题
 *
 * @author: east
 * @date: 2023/10/23
 */

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

public class CatchInfo {
    public static void main(String[] args)
            throws Exception {
        test1();
    }

    public static void test1() {
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                // note 这里实际抛出的异常是Sneeze
                throw a;
            }
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
        } finally {
            System.out.println("Hello World!");
        }
    }

    public static void test2() {
        try {
            try {
                throw new Sneeze();
            } catch (Sneeze s) {
                System.out.println("Caught Sneeze");
                return;
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
//        catch (Annoyance a) {
//            System.out.println("Caught Annoyance");
//        }
        finally {
            System.out.println("Hello World!");
        }
    }
}

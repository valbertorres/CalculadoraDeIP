/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intersys.caluladoraDeIP;

/**
 *
 * @author PROGRAMADOR-02
 */
public class Calculadora {

    private int Ip1;
    private int Ip2;
    private int Ip3;
    private int Ip4;

    private int bitys;
    long aux;

    public Calculadora() {
        this.Ip2 = 0;
        this.Ip3 = 0;
        this.Ip4 = 0;
        this.Ip1 = 0;
        this.bitys = 0;

    }

    public String calcularBinaria() {
        String binario = Integer.toBinaryString(Ip1);
        return binario;
    }

    public String MascaraDeRede() {
        int i = 0;
        String b = "1", c = "0", aBinario = "", bBinario = "", cBinario = "", dBinario = "";
//        StringBuilder aBinario = new StringBuilder();
//        StringBuilder bBinario = new StringBuilder();
//        StringBuilder cBinario = new StringBuilder();
//        StringBuilder dBinario = new StringBuilder();

        while (i < 32) {
            if (i < bitys) {
                if (i < 8) {
                    aBinario += b;

                }
                if (i >= 8 && i < 16) {

                    bBinario += b;
                }
                if (i >= 16 && i < 24) {
//                    cBinario.append(b);
                    cBinario += b;
                }
                if (i >= 24 && i < 32) {
//                    dBinario.append(b);
                    dBinario += b;
                }

            } else {

                if (i < 8) {
//                    aBinario.append(c);
                    aBinario += c;
                }
                if (i >= 8 && i < 16) {
//                    bBinario.append(c);
                    bBinario += c;
                }
                if (i >= 16 && i < 24) {
//                    cBinario.append(c);
                    cBinario += c;
                }
                if (i >= 24 && i < 32) {
//                    dBinario.append(c);
                    dBinario += c;
                }

            }
            i++;
        }

        int amascaraDeRede = Integer.parseInt(aBinario, 2);//Conversão para inteiro
        int bmascaraDeRede = Integer.parseInt(bBinario, 2);
        int cmascaraDeRede = Integer.parseInt(cBinario, 2);
        int dmascaraDeRede = Integer.parseInt(dBinario, 2);

        String mascara = amascaraDeRede + "." + bmascaraDeRede + "." + cmascaraDeRede + "." + dmascaraDeRede;
        return mascara;
    }

    public int CalcularNumeroDeIp() {
        int resultado = 0, resto = 0;

        if (bitys > 24) {
            resultado = 32 - bitys;
            resto = (int) (Math.pow(2, resultado));

        }
        if (bitys <= 24 && bitys > 16) {
            resultado = (32 - bitys);
            resto = (int) (Math.pow(2, resultado));
            if (bitys == 24) {
                resto = 256;
            }

        }
        if (bitys <= 16 && bitys > 8) {
            resultado = (32 - bitys);
            resto = (int) (Math.pow(2, resultado));

        }
        if (bitys <= 8) {
            resultado = ((32 - bitys));
            resto = (int) (Math.pow(2, resultado));

        }

        return resto;
    }

    public int CalculTotalIPsparaUso() {
        int resultado = 0, resto = 0;

        if (bitys > 24 && bitys < 32) {
            resultado = 32 - bitys;
            resto = (int) (Math.pow(2, resultado)) - 2;

        }
        if (bitys <= 24 && bitys > 16) {
            resultado = 32 - bitys;
            resto = (int) (Math.pow(2, resultado)) - 2;

        }
        if (bitys <= 16 && bitys > 8) {
            resultado = 32 - bitys;
            resto = (int) (Math.pow(2, resultado)) - 2;

        }
        if (bitys <= 8) {
            resultado = 32 - bitys;
            resto = (int) (Math.pow(2, resultado)) - 2;

        }

        return resto;
    }

    public String CalcularBroadcast() {
        int resultado = 0, resto = 0;

        if (bitys > 24) {
            resultado = 32 - bitys;
            resto = (int) (Math.pow(2, resultado)) - 1;
            Ip4 = resto;
        }
        if (bitys <= 24 && bitys > 16) {
            resultado = (32 - bitys) - 8;
            resto = (int) (Math.pow(2, resultado)) - 1;
            Ip3 = resto;
            Ip4 = 255;
            if (bitys == 24) {
                Ip3 = 1;
            }
        }
        if (bitys <= 16 && bitys > 8) {

            Ip3 = 255;
            Ip4 = 255;
        }
        if (bitys <= 8) {
            resultado = ((32 - bitys) - 32) * -1;
            resto = (int) (Math.pow(2, resultado)) - 1;
            Ip1 = resto;
            Ip2 = 255;
            Ip3 = 255;
            Ip4 = 255;
        }

        String saida = Ip1 + "." + Ip2 + "." + Ip3 + "." + Ip4;
        return saida;
    }

    public String CalcularUltimoHost() {
        int resultado = 0, resto = 0;
        if (bitys == 32) {
            Ip4 = 0;
        }

        if (bitys < 32 && bitys > 24) {
            resultado = 32 - bitys;
            resto = (int) (Math.pow(2, resultado)) - 2;
            Ip4 = resto;
        }
        if (bitys <= 24 && bitys > 16) {
            resultado = (32 - bitys) - 8;
            resto = (int) (Math.pow(2, resultado)) - 1;
            Ip3 = resto;
            Ip4 = 254;

        }
        if (bitys <= 16 && bitys > 8) {

            Ip3 = 255;
            Ip4 = 254;
        }
        if (bitys <= 8) {
            resultado = ((32 - bitys) - 32) * -1;
            resto = (int) (Math.pow(2, resultado)) - 2;
            Ip1 = resto;
            Ip2 = 255;
            Ip3 = 255;
            Ip4 = 254;
        }
        String saida = Ip1 + "." + Ip2 + "." + Ip3 + "." + Ip4;
        return saida;
    }

    public String CalcularHostMinimo() {

        if (bitys > 24) {
            Ip4 = 1;
            Ip3 = (int) getIp3();
            Ip2 = (int) getIp2();
            Ip1 = (int) getIp1();
        }
        if (bitys <= 24 && bitys > 16) {
            Ip4 = 1;
            Ip3 = 0;
            Ip2 = (int) getIp2();
            Ip1 = (int) getIp1();
            if (bitys == 24) {
                Ip3 = 1;
            }
        }
        if (bitys <= 16 && bitys > 8) {
            
            Ip4 = 1;
            Ip3 = 0;
            
            Ip2 = (int) getIp2();
            Ip1 = (int) getIp1();
        }
        if (bitys <= 8) {
            Ip4 = 1;
            Ip3 = 0;
            Ip2 = 0;
            Ip1 = (int) getIp1();
        }

        String saida = Ip1 + "." + Ip2 + "." + Ip3 + "." + Ip4;
        return saida;

    }

    public String CalcularRanges() {
        int resultado = 0, resto = 0;

        if (bitys > 24) {
            resultado = 32 - bitys;
            resto = (int) (Math.pow(2, resultado)) - 1;
            Ip4 = resto;
        }
        if (bitys <= 24 && bitys > 16) {
            resultado = (32 - bitys) - 8;
            resto = (int) (Math.pow(2, resultado)) + 1;
            Ip3 = resto;
            Ip4 = 256;
            if (bitys == 24) {
                Ip3 = 1;
            }
        }
        if (bitys <= 16 && bitys > 8) {
            resultado = (32 - bitys) - 16;
            resto = (int) (Math.pow(2, resultado)) + 1;
            Ip2 = resto;
            Ip3 = 255;
            Ip4 = 256;
        }
        if (bitys <= 8) {
            resultado = ((32 - bitys) - 32) * -1;
            resto = (int) (Math.pow(2, resultado)) + 1;
            Ip1 = resto;
            Ip2 = 255;
            Ip3 = 255;
            Ip4 = 256;
        }
        String saida = Ip1 + "." + Ip2 + "." + Ip3 + "." + Ip4;
        return saida;

    }
//    public int     CalcularBroadcat(){
//        
//    }

    /**
     * @return the decimal1
     */
    /**
     * @return the bitys
     */
    public long getBitys() {
        return bitys;
    }

    /**
     * @param bitys the bitys to set
     * @throws java.lang.Exception
     */
    public void setBitys(int bitys) throws Exception {
        if (bitys < 0 || bitys > 32) {
            throw new Exception("valor não pode ser menor que zero ou maior que 32");
        }
        this.bitys = bitys;
    }

    /**
     * @return the Ip
     */
    public long getIp1() {
        return Ip1;
    }

    public long getIp2() {
        return Ip2;
    }

    public long getIp3() {
        return Ip3;
    }

    public long getIp4() {
        return Ip4;
    }

    /**
     * @param Ip the Ip to set
     */
    public void setIp1(int Ip1) throws Exception {
        {
            if (Ip1 < 0 || Ip1 > 255) {
                throw new Exception("digite um IP valido!");
            }
        }
        this.Ip1 = Ip1;
    }

    public void setIp2(int Ip2) throws Exception {
        {
            if (Ip2 < 0 || Ip2 > 255) {
                throw new Exception("digite um IP valido!");
            }
        }
        this.Ip2 = Ip2;
    }

    public void setIp3(int Ip3) throws Exception {
        {
            if (Ip3 < 0 || Ip3 > 255) {
                throw new Exception("digite um IP valido!");
            }
        }
        this.Ip3 = Ip3;
    }

    public void setIp4(int Ip4) throws Exception {
        {
            if (Ip4 < 0 || Ip4 > 255) {
                throw new Exception("digite um IP valido!");
            }
        }
        this.Ip4 = Ip4;
    }

    public String toString() {
        return Ip1 + "." + Ip2 + "." + Ip3 + "." + Ip4;
    }

}

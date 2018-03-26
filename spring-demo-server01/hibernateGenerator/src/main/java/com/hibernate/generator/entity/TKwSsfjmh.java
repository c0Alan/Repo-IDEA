package com.hibernate.generator.entity;

import java.sql.Date;

public class TKwSsfjmh {
    /** 编号 */
    private String cBh;
    /** 案件编号 */
    private String cAjbh;
    /** 案件类别 */
    private short nAjlb;
    /** 收录来源 */
    private int nSlly;
    /** 受救助人 */
    private String cSjzr;
    /** 申请救助类型 */
    private String cSqjzlx;
    /** 申请救助原因 */
    private String cSqjzyy;
    /** 救助案件类型 */
    private String cJzajlx;
    /** 救助对象类型 */
    private String cJzdxlx;
    /** 减免缓依据 */
    private String cJmhyj;
    /** 申请减交金额 */
    private Integer nSqjjje;
    /** 申请缓交金额 */
    private Integer nSqhjje;
    /** 缓交期限(天) */
    private Integer nHjqxT;
    /** 缓交期限(月) */
    private Integer nHjqxY;
    /** 缓交截止阶段 */
    private Integer nHjjzjd;
    /** 是否审批 */
    private Short nSfSp;
    /** 审批人 */
    private String cSpr;
    /** 审批日期 */
    private Date dSprq;
    /** 审批状态 */
    private Short nSpzt;
    /** 批示意见/审批结果 */
    private Short nPsyj;

    public String getcBh() {
        return cBh;
    }

    public void setcBh(String cBh) {
        this.cBh = cBh;
    }

    public String getcAjbh() {
        return cAjbh;
    }

    public void setcAjbh(String cAjbh) {
        this.cAjbh = cAjbh;
    }

    public short getnAjlb() {
        return nAjlb;
    }

    public void setnAjlb(short nAjlb) {
        this.nAjlb = nAjlb;
    }

    public int getnSlly() {
        return nSlly;
    }

    public void setnSlly(int nSlly) {
        this.nSlly = nSlly;
    }

    public String getcSjzr() {
        return cSjzr;
    }

    public void setcSjzr(String cSjzr) {
        this.cSjzr = cSjzr;
    }

    public String getcSqjzlx() {
        return cSqjzlx;
    }

    public void setcSqjzlx(String cSqjzlx) {
        this.cSqjzlx = cSqjzlx;
    }

    public String getcSqjzyy() {
        return cSqjzyy;
    }

    public void setcSqjzyy(String cSqjzyy) {
        this.cSqjzyy = cSqjzyy;
    }

    public String getcJzajlx() {
        return cJzajlx;
    }

    public void setcJzajlx(String cJzajlx) {
        this.cJzajlx = cJzajlx;
    }

    public String getcJzdxlx() {
        return cJzdxlx;
    }

    public void setcJzdxlx(String cJzdxlx) {
        this.cJzdxlx = cJzdxlx;
    }

    public String getcJmhyj() {
        return cJmhyj;
    }

    public void setcJmhyj(String cJmhyj) {
        this.cJmhyj = cJmhyj;
    }

    public Integer getnSqjjje() {
        return nSqjjje;
    }

    public void setnSqjjje(Integer nSqjjje) {
        this.nSqjjje = nSqjjje;
    }

    public Integer getnSqhjje() {
        return nSqhjje;
    }

    public void setnSqhjje(Integer nSqhjje) {
        this.nSqhjje = nSqhjje;
    }

    public Integer getnHjqxT() {
        return nHjqxT;
    }

    public void setnHjqxT(Integer nHjqxT) {
        this.nHjqxT = nHjqxT;
    }

    public Integer getnHjqxY() {
        return nHjqxY;
    }

    public void setnHjqxY(Integer nHjqxY) {
        this.nHjqxY = nHjqxY;
    }

    public Integer getnHjjzjd() {
        return nHjjzjd;
    }

    public void setnHjjzjd(Integer nHjjzjd) {
        this.nHjjzjd = nHjjzjd;
    }

    public Short getnSfSp() {
        return nSfSp;
    }

    public void setnSfSp(Short nSfSp) {
        this.nSfSp = nSfSp;
    }

    public String getcSpr() {
        return cSpr;
    }

    public void setcSpr(String cSpr) {
        this.cSpr = cSpr;
    }

    public Date getdSprq() {
        return dSprq;
    }

    public void setdSprq(Date dSprq) {
        this.dSprq = dSprq;
    }

    public Short getnSpzt() {
        return nSpzt;
    }

    public void setnSpzt(Short nSpzt) {
        this.nSpzt = nSpzt;
    }

    public Short getnPsyj() {
        return nPsyj;
    }

    public void setnPsyj(Short nPsyj) {
        this.nPsyj = nPsyj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TKwSsfjmh tKwSsfjmh = (TKwSsfjmh) o;

        if (nAjlb != tKwSsfjmh.nAjlb) return false;
        if (nSlly != tKwSsfjmh.nSlly) return false;
        if (cBh != null ? !cBh.equals(tKwSsfjmh.cBh) : tKwSsfjmh.cBh != null) return false;
        if (cAjbh != null ? !cAjbh.equals(tKwSsfjmh.cAjbh) : tKwSsfjmh.cAjbh != null) return false;
        if (cSjzr != null ? !cSjzr.equals(tKwSsfjmh.cSjzr) : tKwSsfjmh.cSjzr != null) return false;
        if (cSqjzlx != null ? !cSqjzlx.equals(tKwSsfjmh.cSqjzlx) : tKwSsfjmh.cSqjzlx != null) return false;
        if (cSqjzyy != null ? !cSqjzyy.equals(tKwSsfjmh.cSqjzyy) : tKwSsfjmh.cSqjzyy != null) return false;
        if (cJzajlx != null ? !cJzajlx.equals(tKwSsfjmh.cJzajlx) : tKwSsfjmh.cJzajlx != null) return false;
        if (cJzdxlx != null ? !cJzdxlx.equals(tKwSsfjmh.cJzdxlx) : tKwSsfjmh.cJzdxlx != null) return false;
        if (cJmhyj != null ? !cJmhyj.equals(tKwSsfjmh.cJmhyj) : tKwSsfjmh.cJmhyj != null) return false;
        if (nSqjjje != null ? !nSqjjje.equals(tKwSsfjmh.nSqjjje) : tKwSsfjmh.nSqjjje != null) return false;
        if (nSqhjje != null ? !nSqhjje.equals(tKwSsfjmh.nSqhjje) : tKwSsfjmh.nSqhjje != null) return false;
        if (nHjqxT != null ? !nHjqxT.equals(tKwSsfjmh.nHjqxT) : tKwSsfjmh.nHjqxT != null) return false;
        if (nHjqxY != null ? !nHjqxY.equals(tKwSsfjmh.nHjqxY) : tKwSsfjmh.nHjqxY != null) return false;
        if (nHjjzjd != null ? !nHjjzjd.equals(tKwSsfjmh.nHjjzjd) : tKwSsfjmh.nHjjzjd != null) return false;
        if (nSfSp != null ? !nSfSp.equals(tKwSsfjmh.nSfSp) : tKwSsfjmh.nSfSp != null) return false;
        if (cSpr != null ? !cSpr.equals(tKwSsfjmh.cSpr) : tKwSsfjmh.cSpr != null) return false;
        if (dSprq != null ? !dSprq.equals(tKwSsfjmh.dSprq) : tKwSsfjmh.dSprq != null) return false;
        if (nSpzt != null ? !nSpzt.equals(tKwSsfjmh.nSpzt) : tKwSsfjmh.nSpzt != null) return false;
        if (nPsyj != null ? !nPsyj.equals(tKwSsfjmh.nPsyj) : tKwSsfjmh.nPsyj != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cBh != null ? cBh.hashCode() : 0;
        result = 31 * result + (cAjbh != null ? cAjbh.hashCode() : 0);
        result = 31 * result + (int) nAjlb;
        result = 31 * result + nSlly;
        result = 31 * result + (cSjzr != null ? cSjzr.hashCode() : 0);
        result = 31 * result + (cSqjzlx != null ? cSqjzlx.hashCode() : 0);
        result = 31 * result + (cSqjzyy != null ? cSqjzyy.hashCode() : 0);
        result = 31 * result + (cJzajlx != null ? cJzajlx.hashCode() : 0);
        result = 31 * result + (cJzdxlx != null ? cJzdxlx.hashCode() : 0);
        result = 31 * result + (cJmhyj != null ? cJmhyj.hashCode() : 0);
        result = 31 * result + (nSqjjje != null ? nSqjjje.hashCode() : 0);
        result = 31 * result + (nSqhjje != null ? nSqhjje.hashCode() : 0);
        result = 31 * result + (nHjqxT != null ? nHjqxT.hashCode() : 0);
        result = 31 * result + (nHjqxY != null ? nHjqxY.hashCode() : 0);
        result = 31 * result + (nHjjzjd != null ? nHjjzjd.hashCode() : 0);
        result = 31 * result + (nSfSp != null ? nSfSp.hashCode() : 0);
        result = 31 * result + (cSpr != null ? cSpr.hashCode() : 0);
        result = 31 * result + (dSprq != null ? dSprq.hashCode() : 0);
        result = 31 * result + (nSpzt != null ? nSpzt.hashCode() : 0);
        result = 31 * result + (nPsyj != null ? nPsyj.hashCode() : 0);
        return result;
    }
}

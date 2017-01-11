/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;

/**
 *
 * @author Jovan
 */
public class InventoryResponse implements Serializable {

    private int artiklId;
    private int returnCode;
    private String comment;

    public int getArtiklId() {
        return artiklId;
    }

    public void setArtiklId(int artiklId) {
        this.artiklId = artiklId;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "InventoryResponse{" + "artiklId=" + artiklId + ", returnCode=" + returnCode + ", comment=" + comment + '}';
    }
    
    

}

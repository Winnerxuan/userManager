package com.example.bean;

import java.io.Serializable;

public class Actionlist implements Serializable {
    private Integer actionlist;

    private String name;

    private Integer permissionid;

    private static final long serialVersionUID = 1L;

    public Integer getActionlist() {
        return actionlist;
    }

    public void setActionlist(Integer actionlist) {
        this.actionlist = actionlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Actionlist other = (Actionlist) that;
        return (this.getActionlist() == null ? other.getActionlist() == null : this.getActionlist().equals(other.getActionlist()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPermissionid() == null ? other.getPermissionid() == null : this.getPermissionid().equals(other.getPermissionid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActionlist() == null) ? 0 : getActionlist().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPermissionid() == null) ? 0 : getPermissionid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", actionlist=").append(actionlist);
        sb.append(", name=").append(name);
        sb.append(", permissionid=").append(permissionid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
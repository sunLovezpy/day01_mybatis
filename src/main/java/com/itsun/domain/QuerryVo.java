package com.itsun.domain;

import java.util.List;

public class QuerryVo {
    private User user;
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "QuerryVo{" +
                "user=" + user +
                ", ids=" + ids +
                '}';
    }
}

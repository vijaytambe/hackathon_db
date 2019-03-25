package com.qp.osql.logic;

import com.qp.osql.master.Table;

import java.util.List;

public abstract class BDLogic {

    public abstract int insert(Table table);

    public abstract int update(Table table);

    public abstract int delete(Table table);

    public abstract long updateInBulk(List<?> list);

    public abstract long insertInBulk(List<?> list);

    public abstract long deleteInBulk(List<?> list);

    public abstract boolean clear();

    public abstract int size();

    public abstract int cloneMe();
}

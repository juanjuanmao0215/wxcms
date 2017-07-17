package cn.com.lzt.mapper;

import java.io.Serializable;

public interface BaseMapper<T> {

	public void add(T t);

	public void deleteById(Serializable id);

	public void update(T t);

	public T findById(Serializable id);

}

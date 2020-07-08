package com.lq.position.dao.dao;

import java.util.List;

import com.lq.position.domain.Position;

public interface PositionDAO {
	public boolean add(Position p);
	public List<Position> list();
	public Position listByPid(String pid,String cid);
	public boolean off(String pid);
	public boolean on(String pid);
	public List<Position> listoff();
	public boolean del(String pid);
}

package com.leaf.club.service.impl;


import com.leaf.club.dao.IIndexShowDao;
import com.leaf.club.model.IndexShow;
import com.leaf.club.service.IIndexShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LL
 */
@Service("indexShowService")
public class IndexShowServiceImpl implements IIndexShowService{

    @Autowired
    private IIndexShowDao indexShowDao;

    @Override
    public IndexShow getIndexShowById(int id){
        return indexShowDao.getIndexShowById(id);
    }
}

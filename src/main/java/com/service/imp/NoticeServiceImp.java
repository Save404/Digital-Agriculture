package com.service.imp;

import com.common.commonUtils.UUIDUtil;
import com.common.constant.UserConstant;
import com.dao.GovDao;
import com.dao.MjDao;
import com.dao.NhDao;
import com.dao.NoticeDao;
import com.domain.Gov;
import com.domain.MjBasic;
import com.domain.MjMore;
import com.domain.Notice;
import com.dto.GovPmsnDto;
import com.dto.MjMoreDto;
import com.dto.NhMoreDto;
import com.exception.GlobalException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.result.CodeMsg;
import com.service.NoticeService;
import com.vo.NoticeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImp implements NoticeService {

    @Autowired
    NoticeDao noticeDao;

    @Autowired
    NhDao nhDao;

    @Autowired
    MjDao mjDao;

    @Autowired
    GovDao govDao;

    @Override
    public boolean addNotice(GovPmsnDto gov, Notice notice) {
        notice.setNoticeId(UUIDUtil.uuid());
        notice.setDepartmentId(gov.getGovDepartmentId());
        notice.setCreateTime(new Date());
        notice.setReadNum(0);
        return noticeDao.addNotice(notice) == 1;
    }

    @Override
    public boolean deleteNotice(GovPmsnDto gov, String id) {
        //查询这篇公告
        Notice notice = noticeDao.findNoticeByNoticeId(id);
        if (notice == null){
            throw new GlobalException(CodeMsg.RESOURCE_NOT_EXIST_ERROR);
        }

        //政府人员是否能删除这篇公告
        if (gov.getGovDepartmentId() != notice.getDepartmentId()){
            throw new GlobalException(CodeMsg.USER_ERROR);
        }else{
             return noticeDao.deleteNoticeByNoticeId(id) == 1;
        }
    }

    @Override
    @Transactional
    public boolean updateNotice(GovPmsnDto gov, String id, Notice notice) {
        //查询公告
        Notice oldNotice = noticeDao.findNoticeByNoticeId(id);
        if (oldNotice == null){
            throw new GlobalException(CodeMsg.RESOURCE_NOT_EXIST_ERROR);
        }
        //政府人员能否更新这篇公告
        if (oldNotice.getDepartmentId() != gov.getGovDepartmentId()){
            throw new GlobalException(CodeMsg.USER_ERROR);
        }
        //更新操作
        notice.setNoticeId(oldNotice.getNoticeId());
        notice.setDepartmentId(oldNotice.getDepartmentId());
        if (noticeDao.deleteNoticeByNoticeId(id) == 1){
            return noticeDao.addNotice(notice) == 1;
        }
        return false;
    }

    @Override
    @Transactional
    public NoticeView getDetailNotice(String id) {
        //注解查询，判断是否为空
        NoticeView noticeView = noticeDao.findNoticeViewById(id);
        if (noticeView == null){
            throw new GlobalException(CodeMsg.RESOURCE_NOT_EXIST_ERROR);
        }
        noticeDao.incrNoticeReadNum(id);
        return noticeView;
    }

    @Override
    public PageInfo<NoticeView> getNoticeList(String type, String id, int currentPage, int size) {
        List<NoticeView>list = null;
        if (type.toUpperCase().equals(UserConstant.USER_TYPE_MJ)){
            MjMoreDto mj = mjDao.getMjMoreDtoByBasicId(id);
            if (mj == null){
                throw new GlobalException(CodeMsg.LOGIN_ERROR);
            }
            PageHelper.startPage(currentPage, size);
            list = noticeDao.findNoticesByRegionCodeOrderByTimeDesc(mj.getMjACode());
        }
        else if (type.toUpperCase().equals(UserConstant.USER_TYPE_NH)){
            NhMoreDto nh =  nhDao.getNhMoreDtoByBasicId(id);
            if (nh == null){
                throw new GlobalException(CodeMsg.LOGIN_ERROR);
            }
            PageHelper.startPage(currentPage, size);
            list = noticeDao.findNoticesByRegionCodeOrderByTimeDesc(nh.getNhGhdwAreaCode());
        }else if (type.toUpperCase().equals(UserConstant.USER_TYPE_GOV)){
            Gov gov = govDao.getGovById(id);
            if (gov == null){
                throw new GlobalException(CodeMsg.LOGIN_ERROR);
            }
            PageHelper.startPage(currentPage, size);
            list = noticeDao.findNoticesByDepartmentIdOrderByTimeDesc(gov.getGovDepartmentId());
        }
        else{
            throw new GlobalException(CodeMsg.PARAM_ERROR);
        }
        return new PageInfo<NoticeView>(list);
    }
}

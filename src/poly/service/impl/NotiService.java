package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.NotiDTO;
import poly.dto.pagingDTO;
import poly.persistance.mapper.NotiMapper;
import poly.service.INotiService;

@Service("NotiService")
public class NotiService implements INotiService {

	@Resource(name="NotiMapper")
	private NotiMapper notiMapper;
	@Override
	public int insertNotiInfo(NotiDTO nDTO) throws Exception {
		// TODO Auto-generated method stub
		return notiMapper.insertNotiInfo(nDTO);
	}
	@Override
	public List<NotiDTO> getNotiList(pagingDTO pDTO) throws Exception {
		// TODO Auto-generated method stub
		return notiMapper.getNotiList(pDTO);
	}
	@Override
	public NotiDTO getNotiDetail(String seq) throws Exception {
		// TODO Auto-generated method stub
		return notiMapper.getNotiDetail(seq);
	}
	@Override
	public int updateNoti(NotiDTO nDTO) throws Exception {
		// TODO Auto-generated method stub
		return notiMapper.updateNoti(nDTO);
	}
	@Override
	public int deleteNoti(String seq) throws Exception {
		// TODO Auto-generated method stub
		return notiMapper.deleteNoti(seq);
	}
	@Override
	public void viewcount(String notiNo) throws Exception {
		// TODO Auto-generated method stub
		notiMapper.viewcount(notiNo);
	}
	@Override
	public int getNotiTotal() throws Exception {
		// TODO Auto-generated method stub
		return notiMapper.getNotiTotal();
	}

}

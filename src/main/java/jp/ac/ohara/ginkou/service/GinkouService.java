package jp.ac.ohara.ginkou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.ginkou.model.Ginkou;
import jp.ac.ohara.ginkou.repository.GinkouRepository;

@Service
@Transactional
public class GinkouService {

	@Autowired
	private GinkouRepository repository;

	/**
	 * 口座一覧の取得
	 * @return List<AddressBook>
	 */
	public List<Ginkou> getAddressList() {
	    List<Ginkou> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public Ginkou get(@NonNull Long index) {
		Ginkou addressBook = this.repository.findById(index).orElse(new Ginkou());
		return addressBook;
	}

	/**
	 * 口座の保存
	 * @param AddressBook addressBook
	 */
	public void save(@NonNull Ginkou address) {
		this.repository.save(address);
	}

	/**
	 * 口座データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}
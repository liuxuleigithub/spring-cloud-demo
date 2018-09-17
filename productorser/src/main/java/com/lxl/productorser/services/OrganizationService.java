package com.lxl.productorser.services;

import com.lxl.productorser.bean.Organization;
import com.lxl.productorser.repository.OrganizationJpaRepository;
import com.lxl.productorser.repository.OrganizationCrudRepository;
import com.lxl.productorser.repository.OrganizationMybatis;
import com.lxl.productorser.repository.OrganizationPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationCrudRepository orgRepository;

    @Autowired
    private OrganizationJpaRepository organizationJpaRepository;

    @Autowired
    private OrganizationPagingAndSortingRepository organizationPagingAndSortingRepository;

    @Autowired
    private OrganizationMybatis organizationMybatis;


    public Iterable<Organization> findAll() {
        return orgRepository.findAll();
    }


    public Page<Organization> findAllByPagingAndSorting(Pageable pageable) {
        return organizationPagingAndSortingRepository.findAll(pageable);
    }

    public List<Organization> findAllByJpa() {
        return organizationMybatis.findList();
    }

     public Organization getOrg(String organizationId) {
            return orgRepository.findById(organizationId);
     }

    public void saveOrg(Organization org){
        org.setId( UUID.randomUUID().toString());

        orgRepository.save(org);
    }

    public void updateOrg(Organization org){
        orgRepository.save(org);

    }

    public void deleteOrg(String orgId){
        orgRepository.delete( orgId );
    }
}

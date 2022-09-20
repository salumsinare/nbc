/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2022

 *  Created on 20 Sep 2022
 */
package tz.salum.sinare.nbc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tz.salum.sinare.nbc.constant.XY;
import tz.salum.sinare.nbc.model.Transaction;

/**
 *
 * @author A243345
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    public List<Transaction> findByPartnerInstitution(XY institution);
}

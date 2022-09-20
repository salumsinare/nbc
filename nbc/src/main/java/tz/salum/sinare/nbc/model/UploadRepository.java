/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2022

 *  Created on 20 Sep 2022
 */
package tz.salum.sinare.nbc.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author A243345
 */
public interface UploadRepository extends JpaRepository<PartnersTransactions, Long> {

}

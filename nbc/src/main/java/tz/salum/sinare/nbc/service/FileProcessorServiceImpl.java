/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2022

 *  Created on 20 Sep 2022
 */
package tz.salum.sinare.nbc.service;

import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tz.salum.sinare.nbc.constant.XY;
import tz.salum.sinare.nbc.model.Partner;
import tz.salum.sinare.nbc.model.Transaction;
import tz.salum.sinare.nbc.repository.*;

/**
 *
 * @author A243345
 */
@Service
public class FileProcessorServiceImpl implements FileProcessorService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void process(Partner partner) {
        //////////////
        String data = new String(partner.getData());
        // Read csv
        String[] rows = data.split("\n");
        String[] col = rows[0].split(",");
        // transactionRef=col[0]
        // amount=col[1]
        // amount=col[2]

        int i = 1;
        while (i < (rows.length - 1)) {
            Transaction t = new Transaction();
            String[] a = rows[i].split(",");
            t.setTransactionRef(a[0]);
            t.setAccount(a[1]);
            t.setAmount(a[2]);
            t.setPartner(partner);
            transactionRepository.save(t);
        }

    }

}

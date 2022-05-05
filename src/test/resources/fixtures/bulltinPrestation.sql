INSERT INTO gcmd_commande (id, bulletin_reception, bulltin_prestation_id, capitaine, connaissement, consignataire,
                           date_amarage, date_desamarage, devis_id, escale_id, jauge_brute, lht, mumero_commande,
                           mumero_credit, navire, numero_bc, numero_escale, poste)
VALUES (1, 2, 1, 'capi', 3, 'consi', '2022-04-25', '2022-04-25', 2, 1, 4, 5, 6, 7, 'navire', 8, 9, 'post');

INSERT INTO gcmd_bulltin_prestation (id, code_client, code_nature, date, date_depot, date_probable_execution,
                                     description, heure, moyen_odep_client, nom_client, numero_cmd,
                                     numero_dossier_prestation, numero_escale, pre_validation, text, type_paiement)
VALUES (1, 2, 22, '2022-05-04', '2022-04-20', '2022-04-13', 'blabla', '18:59:59', true, 'blabla', 222, 2222, 22222,
        false, 'blabla', 1);
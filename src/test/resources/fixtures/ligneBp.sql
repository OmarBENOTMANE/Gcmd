INSERT INTO gcmd_navire (id, consignataire, date_navire, etat, name, numero_escale) VALUES (1, 'consi ', '2022-04-30', 'etat navire', 'namenavire', 2);

insert into gcmd_escale (id, navire_id, numero_escale) values (1, 1, 2);

INSERT INTO gcmd_bulltin_prestation (id, code_client, code_nature, date, date_depot, date_probable_execution, description, heure, moyen_odep_client, nom_client, numero_cmd, numero_dossier_prestation, numero_escale, pre_validation, text, type_paiement) VALUES (1, 2, 22, '2022-05-04', '2022-04-20', '2022-04-13', 'blabla', '18:59:59', true, 'blabla', 222, 2222, 22222,false, 'blabla', 1);

INSERT INTO gcmd_ligne_bp (id, date, heure, nombre, prestation, produit, sens_trafic, tarif_unifie, tc_conv, tc_suppl, tonnage_minimum, tonnage_reel, bulltin_prestation_id) VALUES (1, '2022-05-01', '13:00:00', 2, 'prest', 'prod', 'IMPORT', true, false, 'tc supp', 4, 5, 1);

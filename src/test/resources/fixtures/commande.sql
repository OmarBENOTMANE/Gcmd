INSERT INTO "gcmd_bulltin_prestation" (id, code_client, code_nature, date, date_depot, date_probable_execution,
                                       description, heure, moyen_odep_client, nom_client, numero_cmd,
                                       numero_dossier_prestation, numero_escale, pre_validation, text, type_paiement)
VALUES (1, 2, 22, '2022-05-04', '2022-04-20', '2022-04-13', 'blabla', '18:59:59', true, 'blabla', 222, 2222, 22222,
        false, 'blabla', 1);

INSERT INTO gcmd_type_client (id, name)
VALUES (1, 'typeclient1');

INSERT INTO gcmd_client (id, email, name, phone, type_client_id)
VALUES (1, 'client1@mail.com', 'client1', '0111111111', 1);

INSERT INTO gcmd_navire (id, consignataire, date_navire, etat, name, numero_escale)
VALUES (1, 'consi ', '2022-04-30', 'etat navire', 'namenavire', 2);

INSERT INTO gcmd_escale (id, navire_id, numero_escale)
VALUES (1, 1, 2);

INSERT INTO gcmd_devis (id, bl, client_id, date, date_facturation, date_sortie, designation, engins_colis, escale_id,
                        import_export, mm_mc, nom_client, nom_navire, nombre_colis, numero_commande, numero_mafi, poids)
VALUES (1, '1', '1', '2022-05-03', '2022-05-05', '2022-05-05', 'desi', 'ENGINS', '1', 'IMPORT', '0', 'nom clie',
        'nom navir', '2', '3', '4', '5.6');


INSERT INTO gcmd_commande (id, bulletin_reception, bulltin_prestation_id, capitaine, connaissement, consignataire,
                           date_amarage, date_desamarage, devis_id, escale_id, jauge_brute, lht, mumero_commande,
                           mumero_credit, navire, numero_bc, numero_escale, poste)
VALUES (1, 2, 1, 'capi', 3, 'consi', '2022-04-25', '2022-04-25', 2, 1, 4, 5, 6, 7, 'navire', 8, 9, 'post');

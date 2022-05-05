INSERT INTO gcmd_type_client (id, name)
VALUES (1, 'typeclient1');

INSERT INTO gcmd_client (id, email, name, phone, type_client_id)
VALUES (1, 'client1@mail.com', 'client1', '0111111111', 1);

INSERT INTO gcmd_navire (id, consignataire, date_navire, etat, name, numero_escale)
VALUES (1, 'consi ', '2022-04-30', 'etat navire', 'namenavire', 2);

insert into gcmd_escale (id, navire_id, numero_escale)
values (1, 1, 2);

INSERT INTO gcmd_devis (id, bl, client_id, date, date_facturation, date_sortie, designation, engins_colis, escale_id,
                        import_export, mm_mc, nom_client, nom_navire, nombre_colis, numero_commande, numero_mafi, poids)
VALUES (1, '2', 1, '2022-05-03', '2022-05-04', '2022-05-05', 'desi devi', 'ENGINS', '1', 'IMPORT', 'MM', 'CLIEN NAM',
        'NAM NAVIR', '3', '4', '5', '6.7');

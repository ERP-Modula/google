INSERT INTO google_docs.action_parameters (id, help, label, name, required, type, parent_action_parameter_id) VALUES (1, null, 'Connection', 'connection', true, 'account:google', null);
INSERT INTO google_docs.action_parameters (id, help, label, name, required, type, parent_action_parameter_id) VALUES (2, null, 'Destination', 'destination', true, 'select', 1);
INSERT INTO google_docs.action_parameters (id, help, label, name, required, type, parent_action_parameter_id) VALUES (3, null, 'File ID', 'folder', false, 'string', 2);

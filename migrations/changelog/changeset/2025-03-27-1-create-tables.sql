-- liquibase formatted sql

-- changeset ivanvaryuhin:1743109401042-1
CREATE TABLE "input_parameter" ("id" UUID DEFAULT gen_random_uuid() NOT NULL, "help" VARCHAR(255), "label" VARCHAR(255), "name" VARCHAR(255), "required" BOOLEAN, "type" VARCHAR(255), CONSTRAINT "input_parameter_pkey" PRIMARY KEY ("id"));

-- changeset ivanvaryuhin:1743109401042-2
CREATE TABLE "module_action" ("id" UUID DEFAULT gen_random_uuid() NOT NULL, "category" VARCHAR(255), "description" VARCHAR(255), "endpoint_url" VARCHAR(255), "label" VARCHAR(255), "name" VARCHAR(255), "interval" BIGINT, "once_running_date" TIMESTAMP WITH TIME ZONE, "scheduled_type" SMALLINT, "time" VARCHAR(255), CONSTRAINT "module_action_pkey" PRIMARY KEY ("id"));

-- changeset ivanvaryuhin:1743109401042-3
CREATE TABLE "module_configuration" ("id" UUID DEFAULT gen_random_uuid() NOT NULL, "auth_type" VARCHAR(255), "author_id" VARCHAR(255), "description" VARCHAR(255), "icon_path" VARCHAR(255), "is_public" BOOLEAN, "label" VARCHAR(255), "name" VARCHAR(255), "theme" VARCHAR(255), CONSTRAINT "module_configuration_pkey" PRIMARY KEY ("id"));

-- changeset ivanvaryuhin:1743109401042-4
CREATE TABLE "module_trigger" ("id" UUID DEFAULT gen_random_uuid() NOT NULL, "category" VARCHAR(255), "description" VARCHAR(255), "endpoint_url" VARCHAR(255), "label" VARCHAR(255), "name" VARCHAR(255), "interval" BIGINT, "once_running_date" TIMESTAMP WITH TIME ZONE, "scheduled_type" SMALLINT, "time" VARCHAR(255), "type" VARCHAR(255), CONSTRAINT "module_trigger_pkey" PRIMARY KEY ("id"));

-- changeset ivanvaryuhin:1743109401042-5
CREATE TABLE "nested_field_option" ("id" UUID DEFAULT gen_random_uuid() NOT NULL, "is_default" BOOLEAN, "label" VARCHAR(255), "type" VARCHAR(255), "value" VARCHAR(255), CONSTRAINT "nested_field_option_pkey" PRIMARY KEY ("id"));

-- changeset ivanvaryuhin:1743109401042-6
CREATE TABLE "output_interface" ("id" UUID DEFAULT gen_random_uuid() NOT NULL, "label" VARCHAR(255), "name" VARCHAR(255), "param_type_enum" VARCHAR(255), "time" BOOLEAN NOT NULL, CONSTRAINT "output_interface_pkey" PRIMARY KEY ("id"));

-- changeset ivanvaryuhin:1743109401042-7
CREATE TABLE "input_parameter_options" ("input_parameter_id" UUID NOT NULL, "options_id" UUID NOT NULL);

-- changeset ivanvaryuhin:1743109401042-8
CREATE TABLE "nested_field_option_nested" ("nested_field_option_id" UUID NOT NULL, "nested_id" UUID NOT NULL);

-- changeset ivanvaryuhin:1743109401042-9
CREATE TABLE "module_action_input_parameters" ("module_action_id" UUID NOT NULL, "input_parameters_id" UUID NOT NULL);

-- changeset ivanvaryuhin:1743109401042-10
CREATE TABLE "module_action_output_interface" ("module_action_id" UUID NOT NULL, "output_interface_id" UUID NOT NULL);

-- changeset ivanvaryuhin:1743109401042-11
CREATE TABLE "module_configuration_triggers" ("module_configuration_id" UUID NOT NULL, "triggers_id" UUID NOT NULL);

-- changeset ivanvaryuhin:1743109401042-12
CREATE TABLE "input_parameter_spec" ("input_parameter_id" UUID NOT NULL, "spec_id" UUID NOT NULL);

-- changeset ivanvaryuhin:1743109401042-13
CREATE TABLE "output_interface_spec" ("output_interface_id" UUID NOT NULL, "spec_id" UUID NOT NULL);

-- changeset ivanvaryuhin:1743109401042-14
CREATE TABLE "module_trigger_input_parameters" ("module_trigger_id" UUID NOT NULL, "input_parameters_id" UUID NOT NULL);

-- changeset ivanvaryuhin:1743109401042-15
CREATE TABLE "module_configuration_actions" ("module_configuration_id" UUID NOT NULL, "actions_id" UUID NOT NULL);

-- changeset ivanvaryuhin:1743109401042-16
CREATE TABLE "module_trigger_output_interface" ("module_trigger_id" UUID NOT NULL, "output_interface_id" UUID NOT NULL);

-- changeset ivanvaryuhin:1743109401042-17
ALTER TABLE "input_parameter_options" ADD CONSTRAINT "uk51id94t092gxvi3opq5k46h3h" UNIQUE ("options_id");

-- changeset ivanvaryuhin:1743109401042-18
ALTER TABLE "nested_field_option_nested" ADD CONSTRAINT "uk5a05gtl2l59k70dwa7x0jna60" UNIQUE ("nested_id");

-- changeset ivanvaryuhin:1743109401042-19
ALTER TABLE "module_action_input_parameters" ADD CONSTRAINT "uk6e6ifklm1t2j13wf4ejimtxyd" UNIQUE ("input_parameters_id");

-- changeset ivanvaryuhin:1743109401042-20
ALTER TABLE "module_action_output_interface" ADD CONSTRAINT "uk89gr4tdf5vr0bivd4t73lwcmm" UNIQUE ("output_interface_id");

-- changeset ivanvaryuhin:1743109401042-21
ALTER TABLE "module_configuration_triggers" ADD CONSTRAINT "uk90qp0gb395pi9s383d0vw0bet" UNIQUE ("triggers_id");

-- changeset ivanvaryuhin:1743109401042-22
ALTER TABLE "input_parameter_spec" ADD CONSTRAINT "ukcp730ycalndmyu5ur7vm2op1v" UNIQUE ("spec_id");

-- changeset ivanvaryuhin:1743109401042-23
ALTER TABLE "output_interface_spec" ADD CONSTRAINT "ukk6sr561u60jax9qyoy95pejgq" UNIQUE ("spec_id");

-- changeset ivanvaryuhin:1743109401042-24
ALTER TABLE "module_trigger_input_parameters" ADD CONSTRAINT "ukl8lqovr0k8ut9w55w0i7pjvw0" UNIQUE ("input_parameters_id");

-- changeset ivanvaryuhin:1743109401042-25
ALTER TABLE "module_configuration_actions" ADD CONSTRAINT "uks3serlyr9sj1rfddlyu7q96hh" UNIQUE ("actions_id");

-- changeset ivanvaryuhin:1743109401042-26
ALTER TABLE "module_trigger_output_interface" ADD CONSTRAINT "uku966bddnl34u4vnw8fnn0vdp" UNIQUE ("output_interface_id");

-- changeset ivanvaryuhin:1743109401042-27
CREATE TABLE "google_tokens" ("id" BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, "access_token" VARCHAR(2048), "id_token" VARCHAR(2048), "refresh_token" VARCHAR(2048), "scopes" VARCHAR(2048), "user_email" VARCHAR(255), CONSTRAINT "google_tokens_pkey" PRIMARY KEY ("id"));

-- changeset ivanvaryuhin:1743109401042-28
CREATE TABLE "module_action_days" ("module_action_id" UUID NOT NULL, "days" INTEGER);

-- changeset ivanvaryuhin:1743109401042-29
CREATE TABLE "module_action_months" ("module_action_id" UUID NOT NULL, "months" INTEGER);

-- changeset ivanvaryuhin:1743109401042-30
CREATE TABLE "module_action_scopes" ("module_action_id" UUID NOT NULL, "scopes" VARCHAR(255));

-- changeset ivanvaryuhin:1743109401042-31
CREATE TABLE "module_configuration_categories" ("module_configuration_id" UUID NOT NULL, "categories" VARCHAR(255));

-- changeset ivanvaryuhin:1743109401042-32
CREATE TABLE "module_trigger_days" ("module_trigger_id" UUID NOT NULL, "days" INTEGER);

-- changeset ivanvaryuhin:1743109401042-33
CREATE TABLE "module_trigger_months" ("module_trigger_id" UUID NOT NULL, "months" INTEGER);

-- changeset ivanvaryuhin:1743109401042-34
CREATE TABLE "module_trigger_scopes" ("module_trigger_id" UUID NOT NULL, "scopes" VARCHAR(255));

-- changeset ivanvaryuhin:1743109401042-35
ALTER TABLE "nested_field_option_nested" ADD CONSTRAINT "fk1j2u8pw3efkp7jtpjnoh1kl1s" FOREIGN KEY ("nested_id") REFERENCES "input_parameter" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-36
ALTER TABLE "input_parameter_spec" ADD CONSTRAINT "fk1yjfsg9g8b1e61ysq7a4ncu0n" FOREIGN KEY ("spec_id") REFERENCES "input_parameter" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-37
ALTER TABLE "nested_field_option_nested" ADD CONSTRAINT "fk2lbom0ucuqy4c1luh90csq6nd" FOREIGN KEY ("nested_field_option_id") REFERENCES "nested_field_option" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-38
ALTER TABLE "module_configuration_actions" ADD CONSTRAINT "fk31ltn0bmknwqmyddfdswsk65f" FOREIGN KEY ("module_configuration_id") REFERENCES "module_configuration" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-39
ALTER TABLE "output_interface_spec" ADD CONSTRAINT "fk3ue44k5kfkc3nidb7wdlx7a4k" FOREIGN KEY ("output_interface_id") REFERENCES "output_interface" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-40
ALTER TABLE "module_action_input_parameters" ADD CONSTRAINT "fk44s2x6yrxbnwp8wxxgjgcldoh" FOREIGN KEY ("input_parameters_id") REFERENCES "input_parameter" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-41
ALTER TABLE "input_parameter_options" ADD CONSTRAINT "fk4velyork0uojg80tmld28nfmy" FOREIGN KEY ("options_id") REFERENCES "nested_field_option" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-42
ALTER TABLE "module_configuration_triggers" ADD CONSTRAINT "fk6fae5l9vf306rb1g4h60nuq05" FOREIGN KEY ("module_configuration_id") REFERENCES "module_configuration" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-43
ALTER TABLE "module_configuration_actions" ADD CONSTRAINT "fk771rb4pf3jroxbdi117jcocuf" FOREIGN KEY ("actions_id") REFERENCES "module_action" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-44
ALTER TABLE "module_action_scopes" ADD CONSTRAINT "fk7ha7m90d1kefxhv2nvk65pvo6" FOREIGN KEY ("module_action_id") REFERENCES "module_action" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-45
ALTER TABLE "module_trigger_output_interface" ADD CONSTRAINT "fk941dv9pt91taowypo08es7inn" FOREIGN KEY ("output_interface_id") REFERENCES "output_interface" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-46
ALTER TABLE "output_interface_spec" ADD CONSTRAINT "fkamyme22ehwksv924og43t1yma" FOREIGN KEY ("spec_id") REFERENCES "output_interface" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-47
ALTER TABLE "module_action_months" ADD CONSTRAINT "fkb13i60k6na2hf1ddclnuf0gb6" FOREIGN KEY ("module_action_id") REFERENCES "module_action" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-48
ALTER TABLE "module_action_days" ADD CONSTRAINT "fkb2b058s1xpy20fi42asifuu7y" FOREIGN KEY ("module_action_id") REFERENCES "module_action" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-49
ALTER TABLE "module_trigger_scopes" ADD CONSTRAINT "fkcuvae8kweh431dywwtg6gbis8" FOREIGN KEY ("module_trigger_id") REFERENCES "module_trigger" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-50
ALTER TABLE "module_trigger_months" ADD CONSTRAINT "fkdrqjvx383sdil2wsrpr5o0tw7" FOREIGN KEY ("module_trigger_id") REFERENCES "module_trigger" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-51
ALTER TABLE "module_trigger_output_interface" ADD CONSTRAINT "fkgjyoxd7d2icrx3epc652dkr7p" FOREIGN KEY ("module_trigger_id") REFERENCES "module_trigger" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-52
ALTER TABLE "module_trigger_input_parameters" ADD CONSTRAINT "fkir38dtppa6sw5iilpsmq5ypdk" FOREIGN KEY ("input_parameters_id") REFERENCES "input_parameter" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-53
ALTER TABLE "input_parameter_spec" ADD CONSTRAINT "fkiv4nj2egu6h4e80o3jptk9sye" FOREIGN KEY ("input_parameter_id") REFERENCES "input_parameter" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-54
ALTER TABLE "module_trigger_days" ADD CONSTRAINT "fkjguvrm0kdsxhet1yrbjbw3195" FOREIGN KEY ("module_trigger_id") REFERENCES "module_trigger" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-55
ALTER TABLE "input_parameter_options" ADD CONSTRAINT "fkk27pleh0vx9ay2lf49io1achj" FOREIGN KEY ("input_parameter_id") REFERENCES "input_parameter" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-56
ALTER TABLE "module_configuration_categories" ADD CONSTRAINT "fkl9po574gpfciyax42klrvkk9q" FOREIGN KEY ("module_configuration_id") REFERENCES "module_configuration" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-57
ALTER TABLE "module_action_output_interface" ADD CONSTRAINT "fkm65p74g88ntao1bhglg0nap34" FOREIGN KEY ("output_interface_id") REFERENCES "output_interface" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-58
ALTER TABLE "module_trigger_input_parameters" ADD CONSTRAINT "fknp3vyotk77r3rgt1i5jo4ajr2" FOREIGN KEY ("module_trigger_id") REFERENCES "module_trigger" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-59
ALTER TABLE "module_action_input_parameters" ADD CONSTRAINT "fkppynr754cp9k5s121tg45uqp7" FOREIGN KEY ("module_action_id") REFERENCES "module_action" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-60
ALTER TABLE "module_action_output_interface" ADD CONSTRAINT "fkqhjysorgab7rm3fhrn3pydorl" FOREIGN KEY ("module_action_id") REFERENCES "module_action" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset ivanvaryuhin:1743109401042-61
ALTER TABLE "module_configuration_triggers" ADD CONSTRAINT "fkqm4furouu42xqs1nreql0tpqy" FOREIGN KEY ("triggers_id") REFERENCES "module_trigger" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;


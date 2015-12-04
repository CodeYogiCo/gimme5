delimiter #
create trigger entiresAfterInsertRestraurant after insert on restraurant
for each row
begin
  insert  ignore into activities (category,Entry,location,speciality) values ('restraurant',new.restraurant_name, new.restraurant_location,new.restraurant_speciality);
end#

delimiter ;


delimiter #
create trigger entiresAfterInsertSalon after insert on salon
for each row
begin
  insert ignore into activities (category,Entry,location,speciality) values ('salon',new.salon_name, new.salon_location,new.salon_speciality);
end#

delimiter ;

delimiter #
create trigger entiresAfterInsertGym after insert on gym
for each row
begin
  insert  ignore into activities (category,Entry,location,speciality) values ('gym',new.gym_name, new.gym_location,new.gym_speciality);
end#

delimiter ;

delimiter #
create trigger entiresAfterInsertCompany after insert on company
for each row
begin
   insert  ignore into activities (category,Entry,location,speciality) values ('company',new.company_name, new.company_location,new.company_speciality);
end#

delimiter ;

delimiter #
create trigger entiresAfterInsertCoaching after insert on coaching
for each row
begin
   insert  ignore into activities (category,Entry,location,speciality) values ('coaching',new.coaching_name, new.coaching_location,new.coaching_speciality);
end#

delimiter ;

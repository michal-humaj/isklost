var ACTIONS_URL = "https://www.google.com/calendar/feeds/o776rmha219v92fvejs0hahsso%40group.calendar.google.com/private-6968d2f0aa2dee4823410b8e47fa040c/basic";
var INSTALLATIONS_URL = "https://www.google.com/calendar/feeds/gehqh0ptgh0i2hkh3f1l4tlerg%40group.calendar.google.com/private-65a3820d5b7a4aa1ac390d21d85d93fc/basic";
var RESERVATIONS_URL = "https://www.google.com/calendar/feeds/3jg1lna270kjsjb0jjrhhqo5m8%40group.calendar.google.com/private-57e4356bbde4ecb5ba981a2eedb4dd91/basic";
var SELFTRANSPORTS_URL = "https://www.google.com/calendar/feeds/hq8a7ru1eh0qoj7bpn05amtsg8%40group.calendar.google.com/private-14076798185cd1615e25439fbd969ae8/basic";
var ACTIONS_COLOR = "#7BD148";
var INSTALLATIONS_COLOR = "#F83A22";
var RESERVATIONS_COLOR = "#F691B2";
var SELFTRANSPORTS_COLOR = "#FAD165";
var ACTIONS_BORDER_COLOR = "#48A015";
var INSTALLATIONS_BORDER_COLOR = "#C50700";
var RESERVATIONS_BORDER_COLOR = "#C36080";
var SELFTRANSPORTS_BORDER_COLOR = "#C7A032";
var EVENT_TEXT_COLOR = "#000000";

function calUrlToEventType(url){
    if (url === ACTIONS_URL) {
        return "ACTION";
    } else if (url === INSTALLATIONS_URL) {
        return "INSTALLATION";
    } else if (url === RESERVATIONS_URL) {
        return "RESERVATION";
    } else if (url === SELFTRANSPORTS_URL) {
            return "SELFTRANSPORT";
    }
};

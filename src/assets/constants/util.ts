/* istanbul ignore file */
import {
  days,
  daysFullForm,
  timeRange12To4,
  timeRange4To6,
  timeRange6To12,
} from ".";

export const daysOfDateFunc = () => {
  let daysOfDate: Record<number, string> = {};
  let i = 1;
  while (i < 366) {
    let pair = { [i]: days[i % 7] };
    daysOfDate = { ...daysOfDate, ...pair };
    i++;
  }
  return daysOfDate;
};

export const weekDaysFunc = () => {
  let weekDays: Record<number, string> = {};
  let i = 1;
  while (i < 366) {
    let fullPair = { [i]: daysFullForm[i % 7] };
    weekDays = { ...weekDays, ...fullPair };
    i++;
  }
  return weekDays;
};

export const timeCoversion = (chosenTime: string) => {
  let i = 0;
  while (i < timeRange6To12.length) {
    if (timeRange6To12[i].substring(0, 2) === chosenTime.substring(0, 2)) {
      return timeRange6To12[i];
    }
    i++;
  }
  i = 0;
  while (i < timeRange12To4.length) {
    if (timeRange12To4[i].substring(0, 2) === chosenTime.substring(0, 2)) {
      return timeRange12To4[i];
      i++;
    }
  }
  i = 0;
  while (i < timeRange4To6.length) {
    if (timeRange4To6[i].substring(0, 2) === chosenTime.substring(0, 2)) {
      return timeRange4To6[i];
      i++;
    }
  }
  return chosenTime;
};

export const discountFunc = (length: number) => {
  return length == 0 ? 0 : 100;
};

export const getCurrentDate = () => {
  const current = new Date();
  const yyyy: number = current.getFullYear();
  const mm: number = current.getMonth() + 1;
  const dd: number = current.getDate();
  let mmStr: string = mm.toString();
  let ddStr: string = dd.toString();

  if (mm < 10) {
    mmStr = "0" + mmStr;
  }

  if (dd < 10) {
    ddStr = "0" + ddStr;
  }

  return `${yyyy}-${mmStr}-${ddStr}`;
};

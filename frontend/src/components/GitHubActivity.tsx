import { useEffect, useState } from "react";

import {
  getGithubActivity,
} from "../services/githubService";

import type {
  GithubActivity as Activity,
} from "../types/GithubActivity";

type Props = {
  username: string;
};

export default function GitHubActivity({
  username,
}: Props) {

  const [activity, setActivity] =
    useState<Activity[]>([]);

  useEffect(() => {

    const fetchActivity =
      async () => {

        try {

          const data =
            await getGithubActivity(
              username
            );

          setActivity(data);

        } catch (error) {

          console.error(error);
        }
      };

    fetchActivity();

  }, [username]);

  const activityMap =
    new Map(
      activity.map(item => [
        item.date,
        item.count,
      ])
    );

  const today = new Date();

  const days = [];

  for (
    let i = 364;
    i >= 0;
    i--
  ) {

    const date =
      new Date(today);

    date.setDate(
      today.getDate() - i
    );

    const key =
      date
        .toISOString()
        .split("T")[0];

    const count =
      activityMap.get(key) || 0;

    let color =
      "bg-gray-200";

    if (count >= 1)
      color = "bg-green-300";

    if (count >= 3)
      color = "bg-green-500";

    if (count >= 5)
      color = "bg-green-700";

    days.push(
      <div
        key={key}
        title={`${key}: ${count}`}
        className={`
          h-3
          w-3
          rounded-sm
          ${color}
        `}
      />
    );
  }

  return (
    <div className="bg-white rounded-xl shadow p-6">

      <h2 className="text-2xl font-bold mb-4">
        GitHub Activity
      </h2>

      <p className="text-gray-500 mb-4">
        Last 365 Days
      </p>

      <div
        className="
          grid
          grid-cols-53
          gap-1
          overflow-x-auto
        "
      >
        {days}
      </div>

      <div className="flex gap-2 mt-4 items-center">

        <span className="text-sm">
          Less
        </span>

        <div className="w-3 h-3 bg-gray-200 rounded-sm"></div>
        <div className="w-3 h-3 bg-green-300 rounded-sm"></div>
        <div className="w-3 h-3 bg-green-500 rounded-sm"></div>
        <div className="w-3 h-3 bg-green-700 rounded-sm"></div>

        <span className="text-sm">
          More
        </span>

      </div>

    </div>
  );
}
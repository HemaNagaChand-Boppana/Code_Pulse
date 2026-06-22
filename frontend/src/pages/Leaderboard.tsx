import { useEffect, useState }
from "react";

import MainLayout
from "../layouts/MainLayout";

import type {
  LeaderboardUser
}
from "../types/Leaderboard";

import {
  getLeaderboard
}
from "../services/leaderboardService";

import LeaderboardTable
from "../components/LeaderboardTable";

import LeaderboardPodium
from "../components/LeaderboardPodium";

export default function Leaderboard() {

  const [users, setUsers] =
    useState<LeaderboardUser[]>([]);

  useEffect(() => {

    const fetchLeaderboard =
      async () => {

        try {

          const data =
            await getLeaderboard();

          setUsers(data);

        } catch (error) {

          console.error(error);
        }
      };

    fetchLeaderboard();

  }, []);

  return (
    <MainLayout>

      <h1 className="text-4xl font-bold mb-6">
        Leaderboard
      </h1>

      <LeaderboardPodium
        users={users}
      />

      <LeaderboardTable
        users={users}
      />

    </MainLayout>
  );
}
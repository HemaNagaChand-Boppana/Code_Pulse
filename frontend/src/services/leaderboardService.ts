import api from "../api/axios";
import type { LeaderboardUser } from "../types/Leaderboard";

export const getLeaderboard = async ()
: Promise<LeaderboardUser[]> => {

  const response = await api.get(
    "/api/leaderboard"
  );

  return response.data;
};
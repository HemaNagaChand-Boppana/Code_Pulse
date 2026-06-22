import type {
  LeaderboardUser
} from "../types/Leaderboard";

type Props = {
  users: LeaderboardUser[];
};

export default function LeaderboardPodium({
  users,
}: Props) {

  const first = users[0];
  const second = users[1];
  const third = users[2];

  return (
    <div className="grid md:grid-cols-3 gap-4 mb-8">

      <div className="bg-gray-100 rounded-xl p-6 text-center">

        <div className="text-4xl mb-2">
          🥈
        </div>

        <h2 className="font-bold text-xl">
          {second?.name ?? "-"}
        </h2>

        <p>
          {second?.leaderboardScore ?? 0}
        </p>

      </div>

      <div className="bg-yellow-100 rounded-xl p-8 text-center shadow">

        <div className="text-5xl mb-2">
          🥇
        </div>

        <h2 className="font-bold text-2xl">
          {first?.name ?? "-"}
        </h2>

        <p className="text-xl font-bold">
          {first?.leaderboardScore ?? 0}
        </p>

      </div>

      <div className="bg-orange-100 rounded-xl p-6 text-center">

        <div className="text-4xl mb-2">
          🥉
        </div>

        <h2 className="font-bold text-xl">
          {third?.name ?? "-"}
        </h2>

        <p>
          {third?.leaderboardScore ?? 0}
        </p>

      </div>

    </div>
  );
}
import type { LeaderboardUser }
from "../types/Leaderboard";

type Props = {
  users: LeaderboardUser[];
};

export default function LeaderboardTable({
  users,
}: Props) {

  return (
    <div className="bg-white rounded-xl shadow overflow-hidden">

      <table className="w-full">

        <thead>

          <tr className="bg-gray-100">

            <th className="p-4 text-left">
              Rank
            </th>

            <th className="p-4 text-left">
              Name
            </th>

            <th className="p-4 text-left">
              Score
            </th>

          </tr>

        </thead>

        <tbody>

          {users.map((user, index) => (

            <tr
              key={user.userId}
              className="border-t"
            >

              <td className="p-4">
                #{index + 1}
              </td>

              <td className="p-4">
                {user.name}
              </td>

              <td className="p-4 font-bold">
                {user.leaderboardScore}
              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  );
}